package br.unigranrio.controller;

public interface Exportador {

	public void exportarXML(Exportavel exportavel);
	public void exportarPDF(Long idCaso, Long idProjeto);
	
}
