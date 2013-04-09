package br.unigranrio.bean.requisito.enums;

public enum TipoAtor {
	 
	PRIMARIO("Prim�rio"), SECUNDARIO("Secund�rio"); 
	
	private final String descricao;
	
	TipoAtor( String descricao ){
		this.descricao = descricao;
	}
	
	public String toString() {
		return descricao;
	}
}
