package br.unigranrio.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import br.unigranrio.bean.requisito.CasoDeUso;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ExportadorXml implements Exportador {

	private XStream xstream = new XStream(new DomDriver("UTF-8"));
	
	//ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	//String path = context.getRealPath(File.separator);

	public void exportarXML(Exportavel exCasoDeUso) {

		CasoDeUso casoDeUso = (CasoDeUso) exCasoDeUso;
		
		String nomeArquivo = "C:\\Export\\" + casoDeUso.getCodigo()	+ " - " + casoDeUso.getNome() + ".xml";
		System.out.println(nomeArquivo);
		File arquivoXml = new File(nomeArquivo);

		try {

			FileOutputStream fos = new FileOutputStream(arquivoXml);
			processarAnotacoes();
			xstream.toXML(casoDeUso, fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void exportarPDF(Long idCaso, Long idProjeto){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetofinal", "root", "root");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idCaso", idCaso);
			parametros.put("idProjeto", idProjeto);
			
			String jrxml = "C:\\Export\\export_caso_de_uso.jrxml";
			String jasper = "C:\\Export\\export_caso_de_uso.jasper";
			//JasperDesign jasperDesign = JRXmlLoader.load(jrxml);
			JasperCompileManager.compileReportToFile(jrxml, jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametros, con);
			String arquivo = "C:\\Export\\caso_de_uso.pdf";
			//File pdf = new File(arquivo);
			JasperExportManager.exportReportToPdfFile(jasperPrint, arquivo);
			//JasperManager.printReportToPdfFile(jasperPrint, arquivo);

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause());
		}

	}

	public void processarAnotacoes() {

		try {
			Class[] classes = ClassFinder.getClasses("br.unigranrio.bean.requisito");
			xstream.processAnnotations(classes);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}