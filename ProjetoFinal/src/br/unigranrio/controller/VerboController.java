package br.unigranrio.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class VerboController {

	ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	String realPath = context.getRealPath("\\resources\\dic.txt");
	
	public List<String> recuperaVerbos(){
		List<String> verbos = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader(realPath)).useDelimiter("\\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNext()){
			String verbo = scanner.next();
			verbos.add(verbo);
		}
		return verbos;
	}
	
}
