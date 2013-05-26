package br.unigranrio.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import br.unigranrio.bean.requisito.CasoDeUso;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ExportadorXml implements Exportador {

	private XStream xstream = new XStream(new DomDriver("UTF-8"));
	
	public String exportar(Exportavel exCasoDeUso) {
		
		CasoDeUso casoDeUso = (CasoDeUso)exCasoDeUso;
		
		ServletContext context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		  
	    String path = context.getRealPath("/");
		
		String nomeArquivo =  path + "public" + File.separator + "exportacao" + File.separator + "xml" + File.separator + casoDeUso.getCodigo() + " - " + casoDeUso.getNome() + ".xml";
		
		File arquivoXml = new File(nomeArquivo);
		
		try {
			
			FileOutputStream fos = new FileOutputStream(arquivoXml);
		
			processarAnotacoes();
			xstream.toXML(casoDeUso,fos);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return arquivoXml.getAbsolutePath();
	}
	
	public void processarAnotacoes() {
		
		try {
			Class[ ] classes = ClassFinder.getClasses("br.unigranrio.bean.requisito");
			xstream.processAnnotations(classes);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}