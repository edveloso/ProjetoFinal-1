package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MensagemMB {

	private String mensagem;
	
	public MensagemMB() {	
		mensagem = "Seja bem vindo! Selecione uma opção acima.";
	}
		
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
