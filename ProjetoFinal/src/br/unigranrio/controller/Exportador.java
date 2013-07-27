package br.unigranrio.controller;

public interface Exportador {

	public String exportarXML(Exportavel exportavel);
	public String exportarPDF(Long id);
	
}
