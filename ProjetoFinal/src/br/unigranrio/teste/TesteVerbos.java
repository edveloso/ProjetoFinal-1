package br.unigranrio.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TesteVerbos {

	public static void main(String[] args) throws IOException, FileNotFoundException {

		File arquivo = new File("pt-BR.dic");
		BufferedReader br = null;
		String string = null;
		
		File arquivoNovo = new File("adjetivos.txt"); 
		FileWriter fw = new FileWriter(arquivoNovo);  
		BufferedWriter bw = new BufferedWriter(fw);  
		
		String verbo[] = null;
		
		try {
			FileReader fr = new FileReader(arquivo);
			br = new BufferedReader(fr);
			string = br.readLine();
			while (string != null) {
				string = br.readLine();
				if(string.contains("/fp")){
					verbo = string.split("/");
					System.out.println(verbo[0] + verbo[1]);
					bw.write(verbo[0]+"\n");
					bw.flush();
				}
			}
			bw.close();
			br.close();

		} finally {
			System.out.println("Terminei");;
		}
	}
}
