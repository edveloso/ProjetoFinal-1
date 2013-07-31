package br.unigranrio.teste;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class TesteRelatorio {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetofinal", "root", "root");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idCaso", 1);
			parametros.put("idProjeto", 1);
		
			JasperReport relatorio = JasperCompileManager.compileReport("C:\\Relatorios"+File.separator+"export_caso_de_uso.jrxml");
			System.out.println("C:\\Relatorios"+File.separator+"export_caso_de_uso.jrxml");
			JasperPrint impressao = JasperFillManager.fillReport(relatorio,	parametros, con);
			JasperExportManager.exportReportToPdfFile(impressao, "C:\\Relatorios"+File.separator+"caso.pdf");
			
			con.close();
		} catch (Exception e) {
			e.getCause();
		}

		System.out.println("C:\\Relatorios"+File.separator+"caso.pdf");

	}

}
