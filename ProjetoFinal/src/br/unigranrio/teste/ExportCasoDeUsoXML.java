package br.unigranrio.teste;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;

public class ExportCasoDeUsoXML {


	

	public static void main(String[] args) throws JAXBException, IOException {
	
		
	
		
		Projeto projeto = new Projeto();
		projeto.setNome("primeiro");
		
		Ator ator = new Ator();
		ator.setNome("Joao");
		ator.setProjeto(projeto);
		ator.setTipo("Secundario");
		
		CasoDeUso caso = new CasoDeUso();
		caso.setNome("Manutencao do Sistema");
		caso.setProjeto(projeto);
		caso.setCodigo("UC001");
		caso.setObjetivo("Realizar a manutencao do Sistema");
		caso.setTipo("Abstrato");
		caso.addAtor(ator);
		
		Fluxo flux = new Fluxo();
		flux.setNome("Fluxo 1");
		flux.setTipo("PRINCIPAL");
		flux.setCodigo(1);
		
			
		PosCondicao pos = new PosCondicao();
		pos.setDescricao("Fechar");
		
		
		PreCondicao pre = new PreCondicao();
		pre.setDescricao("Estar Logado no Sistema");
		
		
		RegraDeNegocio regra = new RegraDeNegocio();
		regra.setDescricao("Apresentar resultado da pesquisa: ");
		
		
		RequisitoNaoFuncional req = new RequisitoNaoFuncional();
		req.setDescricao("O sistema devera rodar em qualquer plataforma");
		
		
	
		caso.addFluxos(flux);
		caso.addPreCondicoes(pre);
		caso.addPosCondicoes(pos);
		caso.addRegrasDeNegocio(regra);
		caso.addRequisitosNaoFuncionais(req);
		
	
		
		JAXBContext context = JAXBContext.newInstance(CasoDeUso.class);
		Marshaller marshal = context.createMarshaller();
		
		marshal.marshal(caso, System.out);
		
		FileWriter wr = new FileWriter("Caso.xml");
		marshal.marshal(caso, wr);
	}

}
