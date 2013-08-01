package br.unigranrio.controller;

import br.unigranrio.bean.requisito.CasoDeUso;

public interface Exportador {

	public String exportarXML(Exportavel exportavel);
	public String exportarPDF(CasoDeUso caso, Long idProjeto);
	public String exportarDOCX(CasoDeUso caso, Long idProjeto);
	public String exportarODT(CasoDeUso caso, Long idProjeto);
	
}
