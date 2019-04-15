package view;

import model.vo.AlunoVO;

public class Menu {
	
	public static void main(String[] args) {
		//AlunoBO bo = new AlunoBO();
		AlunoVO novoAluno = new AlunoVO();
		novoAluno.setMatricula("10");
		novoAluno.setNome("Artur");
		
		//Já incluí os novos campos obrigatórios para testar o INSERT
		novoAluno.setSobrenome("Antunes Coimbra");
		novoAluno.setP1(10);
		novoAluno.setP2(9.25);
		novoAluno.setT1(8);
		novoAluno.setT2(9);
		novoAluno.setPesoProvas(0.6);
		novoAluno.setPesoTrabalhos(0.4);
		novoAluno.setNivel("Iniciante");
		novoAluno.setSituacao("Aprovado");
		
		//bo.salvarAluno(novoAluno);
	}
}