package br.unigranrio.teste;

import java.util.ArrayList;
import java.util.List;

import br.unigranrio.controller.VerboController;

public class TesteVerbos {

	public static void main(String[] args) {

		VerboController control = new VerboController();
		List<String> verbos = new ArrayList<String>();
		verbos = control.recuperaVerbos();
		String verbo = null;
		
		for (int i = 10; i < 21; i++) {
			verbo = verbos.get(i);
			System.out.println(verbo);
		}
		
	}

}
