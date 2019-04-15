package controller;

import model.bo.AlunoBO;
import model.vo.AlunoVO;

public class ControllerAluno {

	AlunoBO bo = new AlunoBO();
	
	public String obetrSituacaoESalvar(AlunoVO a) {
		String mensagem = "";
		
		double media = bo.calcularMedia(a);
		salvar(a);
		if (media >= 7.0) {
			mensagem += "Aprovado!";
		} else if (media < 7.0 && media >= 4.5) {
			mensagem += "Recuperação!";
		} else {
			mensagem += "Reprovado!";
		}
		
		return mensagem;
	}
	
	public double notaFinal(AlunoVO a) {
		return bo.calcularMedia(a);
	}
	
	public boolean atualizarSituacao(AlunoVO a) {
		return bo.sitaucao(a);
	}
	
	public String salvar(AlunoVO a) {
		return bo.salvar(a);
	}
}
