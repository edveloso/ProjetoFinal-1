package br.unigranrio.teste;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.enums.TipoAtor;
import br.unigranrio.bean.requisito.enums.TipoCasoDeUso;

public class ExportCasoDeUsoXML {


	public static void main(String[] args) throws JAXBException, IOException {
	
		
		ArrayList<Ator> atores = new ArrayList<Ator>();
		
		Projeto projeto = new Projeto();
		projeto.setNome("primeiro");
		
		CasoDeUso caso = new CasoDeUso();
		caso.setNome("Manutencao do Sistema");
		caso.setProjeto(projeto);
		caso.setCodigo("UC001");
		caso.setObjetivo("Realizar a manutencao do Sistema");
		caso.setTipo(TipoCasoDeUso.ABSTRATO);
	
		
		JAXBContext context = JAXBContext.newInstance(CasoDeUso.class);
		Marshaller marshal = context.createMarshaller();
		
		marshal.marshal(caso, System.out);
		
		FileWriter wr = new FileWriter("Caso.xml");
		marshal.marshal(caso, wr);
	}

}
