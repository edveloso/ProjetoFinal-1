package br.unigranrio.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.bean.requisito.Projeto;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ExportadorFormatos implements Exportador {

	private XStream xstream = new XStream(new DomDriver("UTF-8"));
	private FluxoController fluxoControl = new FluxoController();
	private PassoController passoControl = new PassoController();
	private PosCondicaoController posControl = new PosCondicaoController();
	private PreCondicaoController preControl = new PreCondicaoController();
	
	public String exportar(CasoDeUso caso, Projeto projeto){
		
		String link = null;
		
		if (caso.getFormato().equals("xml")) {
			link = this.exportarXML(caso);
		}

		if(caso.getFormato().equals("pdf")){
			link = this.exportarPDF(caso, projeto.getId());
		}
		
		if(caso.getFormato().equals("docx")){
			link = this.exportarDOCX(caso, projeto.getId());
		}
		
		if(caso.getFormato().equals("odt")){
			link = this.exportarODT(caso, projeto.getId());
		}
		
		return link;
		
	}
	
	public String exportarXML(Exportavel exCasoDeUso) {
		
		CasoDeUso casoDeUso =  (CasoDeUso) exCasoDeUso;
		String nomeArquivo = null;
		
		List<Fluxo> fluxos = fluxoControl.selecionarTodosCaso(casoDeUso.getId());
		for (Fluxo fluxo : fluxos) {
			List<Passo> passos = passoControl.selecionarTodosFluxo(fluxo.getId());
			fluxo.setPassosParaXML(passos);
		}

		CasoDeUso ucExp = new CasoDeUso();
		
		ucExp.setAtores(casoDeUso.getAtores());
		ucExp.setCodigo(casoDeUso.getCodigo());
		ucExp.setNome(casoDeUso.getNome());
		ucExp.setObjetivo(casoDeUso.getObjetivo());
		ucExp.setFluxosParaXML(fluxos);
		ucExp.setId(casoDeUso.getId());
		ucExp.setTipo(casoDeUso.getTipo());
		ucExp.setPreCondicoesParaXML(preControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));
		ucExp.setPosCondicoesParaXML(posControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));
		ucExp.setRegrasDeNegocioParaXML(casoDeUso.getRegrasDeNegocioParaXML());
		ucExp.setRequisitosNaoFuncionaisParaXML(casoDeUso.getRequisitosNaoFuncionaisParaXML());

		try {

			nomeArquivo = "C:\\Export\\" + ucExp.getCodigo()	+ " - " + ucExp.getNome() + ".xml";
			File arquivoXml = new File(nomeArquivo);
			FileOutputStream fos = new FileOutputStream(arquivoXml);
			processarAnotacoes();
			xstream.toXML(ucExp, fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return nomeArquivo;
		
	}
	
	public String exportarPDF(CasoDeUso caso, Long idProjeto){
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetofinal", "root", "root");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCaso", caso.getId());
		parametros.put("idProjeto", idProjeto);
		
		String jrxml = "C:\\Export\\export_caso_de_uso.jrxml";
		String jasper = "C:\\Export\\export_caso_de_uso.jasper";
		String arquivo = null;
		
		try {
			arquivo = "C:\\Export\\" + caso.getCodigo()	+ " - " + caso.getNome() + ".pdf";
			
			JasperCompileManager.compileReportToFile(jrxml, jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametros, con);
			JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, arquivo);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.exportReport();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arquivo;
		
	}
	
	public String exportarDOCX(CasoDeUso caso, Long idProjeto){
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetofinal", "root", "root");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCaso", caso.getId());
		parametros.put("idProjeto", idProjeto);
		
		String jrxml = "C:\\Export\\export_caso_de_uso.jrxml";
		String jasper = "C:\\Export\\export_caso_de_uso.jasper";
		String arquivo = null;
		
		try {
			arquivo = "C:\\Export\\" + caso.getCodigo()	+ " - " + caso.getNome() + ".docx";
			
			JasperCompileManager.compileReportToFile(jrxml, jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametros, con);
			JRExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, arquivo);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.exportReport();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arquivo;
		
	}
	
	public String exportarODT(CasoDeUso caso, Long idProjeto){
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetofinal", "root", "root");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCaso", caso.getId());
		parametros.put("idProjeto", idProjeto);
		
		String jrxml = "C:\\Export\\export_caso_de_uso.jrxml";
		String jasper = "C:\\Export\\export_caso_de_uso.jasper";
		String arquivo = null;
		
		try {
			arquivo = "C:\\Export\\" + caso.getCodigo()	+ " - " + caso.getNome() + ".odt";
			
			JasperCompileManager.compileReportToFile(jrxml, jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametros, con);
			JRExporter exporter = new JROdtExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, arquivo);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.exportReport();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arquivo;
		
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