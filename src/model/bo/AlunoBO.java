package model.bo;

import model.dao.AlunoDAO;
import model.vo.AlunoVO;

public class AlunoBO {

	AlunoDAO dao = new AlunoDAO();

	public double calcularMedia(AlunoVO a) {
		double media = 	(((a.getP1() + a.getP2()) * a.getPesoProvas()) / 2 ) + 
				(((a.getT1() + a.getT2()) * a.getPesoTrabalhos()) / 2);
		return media;
	}

	public String salvar(AlunoVO a) {
		String mensagem = "";
		boolean resultado = dao.inserir(a);
		if (resultado == true) {
			mensagem += "Salvo e Calculado!";
		} else {
			mensagem += "Erro ao Salvar e Calcular";
		}
		return mensagem;
	}

	public boolean sitaucao(AlunoVO a) {
		return this.dao.atualizar(a);
	}

}
