package br.unigranrio.teste;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.Projeto;

public class ExportXML {


	public static void main(String[] args) throws JAXBException, IOException {
	
		Projeto projeto = new Projeto();
		projeto.setNome("primeiro");
		
		Ator ator = new Ator();
		ator.setNome("Joao");
		ator.setProjeto(projeto);
		
		JAXBContext context = JAXBContext.newInstance(Ator.class);
		Marshaller marshal = context.createMarshaller();
		
		marshal.marshal(ator, System.out);
		
		FileWriter wr = new FileWriter("Ator.xml");
		marshal.marshal(ator, wr);
	}

}
