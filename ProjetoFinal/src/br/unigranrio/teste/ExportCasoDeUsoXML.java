package br.unigranrio.teste;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.bean.requisito.enums.TipoAtor;
import br.unigranrio.bean.requisito.enums.TipoCasoDeUso;
import br.unigranrio.bean.requisito.enums.TipoFluxo;

public class ExportCasoDeUsoXML {

	public static void main(String[] args) throws JAXBException, IOException {
		
		Projeto projeto = new Projeto();
		projeto.setNome("primeiro");
		
		Collection<Ator> collection = new ArrayList<Ator>();
		ArrayList<Ator> array = new ArrayList<Ator>();
		
		Ator ator1 = new Ator();
		ator1.setNome("Sistema");
		ator1.setTipo(TipoAtor.PRIMARIO);
		collection.add(ator1);
		array.add(ator1);
		
		Ator ator = new Ator();
		ator.setNome("Joao");
		ator.setTipo(TipoAtor.SECUNDARIO);
		collection.add(ator);
		array.add(ator);
		

		CasoDeUso caso = new CasoDeUso();
		caso.setProjeto(projeto);
		caso.setCodigo("UC001");
		caso.setNome("Manutencao do Sistema");
		caso.setObjetivo("Realizar a manutencao do Sistema");
		caso.setTipo(TipoCasoDeUso.ABSTRATO);
		caso.setAtores(array);	
		
		Passo passos = new Passo();
		passos.setAtors(collection);
		passos.setAcao("Acao");
		passos.setComplemento("Complemento");
		
		Fluxo flux = new Fluxo();
		flux.setCodigo(1);
		flux.setTipo(TipoFluxo.PRINCIPAL);
		flux.setNome("Fluxo 1");
		flux.addPassos(passos);
		
			
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
