package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Banco;
import model.vo.AlunoVO;

public class AlunoDAO {

	public boolean inserir(AlunoVO a){

		/*String sql = "INSERT INTO Aluno (nome, sobrenome, MATRICULA, NOTA_P1, NOTA_P2, NOTA_T1,"
				+ " NOTA_T2, NOTAPESOPROVA, NOTAPESOTRABALHO, NIVEL, SITUACAO, NOTA_FINAL) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";*/

		/*String query = "INSERT INTO Aluno (nome, sobrenome, matricula, p1, p2, t1, t2, pesoProvas, pesoTrabalhos, nivel) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";*/
		String query = "INSERT INTO aluno (nome, sobrenome, matricula, p1, p2, t1, t2, pesoProvas, pesoTrabalhos, nivel) "
				+ "VALUES ('"+a.getNome()+"', '"+a.getSobrenome()+"', '"+a.getMatricula()+"', '"+a.getP1()+"', "
				+ "'"+a.getP2()+"', '"+a.getT1()+"', '"+a.getT2()+"', '"+a.getPesoProvas()+"', "
				+ "'"+a.getPesoTrabalhos()+"', '"+a.getNivel()+"')";

		Connection conn = Banco.getConnection();
		PreparedStatement stat = Banco.getPreparedStatement(conn, query);

		try {
				/*stat.setString(1, a.getNome());
				stat.setString(2, a.getSobrenome());
				stat.setString(3, a.getMatricula());
				stat.setDouble(4, a.getP1());
				stat.setDouble(5, a.getP2());
				stat.setDouble(6, a.getT1());
				stat.setDouble(7, a.getT2());
				stat.setDouble(8, a.getPesoProvas());
				stat.setDouble(9, a.getPesoTrabalhos());
				stat.setString(10, a.getNivel());
				stat.setDouble(11, a.getNotaFinal());
				stat.setString(12, a.getSituacao());
				stat.execute();*/
				
				int valorGerado = stat.executeUpdate(query);
				if (valorGerado == 1) {
					return true;
				}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Aluno. Causa: " + e.getCause());
			System.out.println(e.getMessage());
			System.out.println(query);
		} finally{
			Banco.closePreparedStatement(stat);
			Banco.closeConnection(conn);
		}

		return false;
	}

	public boolean atualizar(AlunoVO a){
		boolean sucessoUpdate = false;

		/*String sql = "UPDATE Aluno A SET NOME=?, MATRICULA=?, NOTA_P1=?, NOTA_P2=? "
				+ " WHERE P.ID = ? ";*/
		String query = "UPDATE aluno a SET nome = ?, sobrenome = ?, matricula = ?, p1 = ?, "
				+ "p2 = ?, t1 = ?, t2 = ?, pesoProvas = ?, pesoTrabalhos = ?, nivel = ?, situacao = ?, mediaFinal = ? "
				+ "WHERE a.id = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query);

		try {
			prepStmt.setString(1, a.getNome());
			prepStmt.setString(2, a.getSobrenome());
			prepStmt.setString(3, a.getMatricula());
			prepStmt.setDouble(4, a.getP1());
			prepStmt.setDouble(5, a.getP2());
			prepStmt.setDouble(6, a.getT1());
			prepStmt.setDouble(7, a.getT2());
			prepStmt.setDouble(8, a.getPesoProvas());
			prepStmt.setDouble(9, a.getPesoTrabalhos());
			prepStmt.setString(10, a.getNivel());
			prepStmt.setString(11, a.getSituacao());
			prepStmt.setDouble(12, a.getNotaFinal());
			prepStmt.setDouble(13, a.getId());

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Aluno. Causa: \n:" + e.getCause());
			System.out.println(e.getMessage());
			System.out.println(query);
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}

	public boolean remover(int id){
		boolean sucessoDelete = false;

		String sql = " DELETE FROM Aluno "
				+ " WHERE ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		try {
			prepStmt.setInt(1, id);
			int codigoRetorno = prepStmt.executeUpdate();
			if(codigoRetorno == 1){//1 - sucesso na execução
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao remover Aluno. Causa: \n:" + e.getCause());
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return sucessoDelete;
	}

	public ArrayList<AlunoVO> listarTodos(){
		String query = " SELECT * FROM Aluno ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query);
		ArrayList<AlunoVO> AlunoVOs = new ArrayList<AlunoVO>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while(result.next()){
				AlunoVO AlunoVO = new AlunoVO();

				AlunoVO.setId(result.getInt("id"));
				AlunoVO.setNome(result.getString("nome"));
				AlunoVO.setSobrenome(result.getString("sobrenome"));
				AlunoVO.setMatricula(result.getString("matricula"));
				AlunoVO.setP1(result.getDouble("p1"));
				AlunoVO.setP2(result.getDouble("p2"));
				AlunoVO.setT1(result.getDouble("t1"));
				AlunoVO.setT2(result.getDouble("t2"));
				AlunoVO.setPesoProvas(result.getDouble("pesoProvas"));
				AlunoVO.setNivel(result.getString("nivel"));
				AlunoVO.setSituacao(result.getString("situacao"));
				AlunoVO.setNotaFinal(result.getDouble("mediaFinal"));
				AlunoVOs.add(AlunoVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro listar todos os Alunos. Causa: \n:" + e.getCause());
			System.out.println(e.getMessage());
			System.out.println(query);
		}
		return AlunoVOs;
	}
	/**
	 * Retorna um produto dado um id.
	 * 
	 * @param id o identificador do produto
	 * @return um produto caso o id exista na tabela Produto
	 * 		   null caso contrário
	 */
	public AlunoVO obterPorId(int id){
		String query = " SELECT * FROM Aluno "
				+ " WHERE ID=?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query);
		AlunoVO AlunoVO = null;

		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();

			while(result.next()){
				AlunoVO = new AlunoVO();

				AlunoVO.setId(result.getInt("id"));
				AlunoVO.setNome(result.getString("nome"));
				AlunoVO.setSobrenome(result.getString("sobrenome"));
				AlunoVO.setMatricula(result.getString("matricula"));
				AlunoVO.setP1(result.getDouble("p1"));
				AlunoVO.setP2(result.getDouble("p2"));
				AlunoVO.setT1(result.getDouble("t1"));
				AlunoVO.setT2(result.getDouble("t2"));
				AlunoVO.setPesoProvas(result.getDouble("pesoProvas"));
				AlunoVO.setNivel(result.getString("nivel"));
				AlunoVO.setSituacao(result.getString("situacao"));
				AlunoVO.setNotaFinal(result.getDouble("mediaFinal"));

			}
		} catch (SQLException e) {
			System.out.println("Erro buscar um AlunoVO. Causa: \n:" + e.getCause());
			System.out.println(e.getMessage());
			System.out.println(query);
		}
		return AlunoVO;
	}
}