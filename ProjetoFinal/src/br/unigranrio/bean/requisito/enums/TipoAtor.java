package br.unigranrio.bean.requisito.enums;

public enum TipoAtor {
	 
	PRIMARIO("Primário"), SECUNDARIO("Secundário"); 
	
	private final String descricao;
	
	TipoAtor( String descricao ){
		this.descricao = descricao;
	}
	
	public String toString() {
		return descricao;
	}
}
