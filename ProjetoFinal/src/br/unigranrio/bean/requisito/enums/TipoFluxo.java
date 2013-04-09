package br.unigranrio.bean.requisito.enums;

public enum TipoFluxo {

	PRINCIPAL("Principal"), ALTERNATIVO("Alternativo"), EXCECAO("Exce��o");
	
	private final String descricao;
	
	TipoFluxo( String descricao ){
		this.descricao = descricao;
	}
	
	public String toString() {
		return descricao;
	}
}