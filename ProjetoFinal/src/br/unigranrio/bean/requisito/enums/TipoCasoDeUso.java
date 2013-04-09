package br.unigranrio.bean.requisito.enums;

public enum TipoCasoDeUso {
	 
	CONCRETO("Concreto"), ABSTRATO("Abstrato");
	
	private final String descricao;
	
	TipoCasoDeUso( String descricao ){
		this.descricao = descricao;
	}
	
	public String toString() {
		return descricao;
	}		 
}
