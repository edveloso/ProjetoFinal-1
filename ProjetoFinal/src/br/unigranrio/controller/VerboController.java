package br.unigranrio.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerboController {
	
	public List<String> recuperaVerbos(){
		List<String> verbos = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader("pt-BR.dic")).useDelimiter("\\n|/");
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
