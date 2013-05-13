package br.unigranrio.teste;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.dao.impl.AtorDAO;
import br.unigranrio.dao.impl.CasoDeUsoDAO;
import br.unigranrio.dao.impl.FluxoDAO;
import br.unigranrio.dao.impl.PassoDAO;
import br.unigranrio.dao.impl.PosCondicaoDAO;
import br.unigranrio.dao.impl.PreCondicaoDAO;
import br.unigranrio.dao.impl.ProjetoDAO;
import br.unigranrio.dao.impl.RegraDeNegocioDAO;
import br.unigranrio.dao.impl.RequisitoNaoFuncionalDAO;

public class TesteProjeto {

	public static void main(String[] args) {
		
		ProjetoDAO projDao = new ProjetoDAO();
		AtorDAO atorDao = new AtorDAO();
		CasoDeUsoDAO casoDao = new CasoDeUsoDAO();
		FluxoDAO fluxDao = new FluxoDAO();
		PassoDAO paDao = new PassoDAO();
		PosCondicaoDAO posDao = new PosCondicaoDAO();
		PreCondicaoDAO preDao = new PreCondicaoDAO();
		RegraDeNegocioDAO regraDao = new RegraDeNegocioDAO();
		RequisitoNaoFuncionalDAO reqDao = new RequisitoNaoFuncionalDAO();
				
		Projeto projeto = new Projeto();
		projeto.setNome("primeiro");
		
		Ator ator = new Ator();
		ator.setNome("Joao");
		ator.setProjeto(projeto);
		ator.setTipo("Secundatio");
		
		CasoDeUso caso = new CasoDeUso();
		caso.setNome("Manutenção do Sistema");
		caso.setProjeto(projeto);
		caso.setCodigo("UC001 -");
		caso.setObjetivo("Realizar a manutenção do Sistema");
		caso.setTipo("Abstrato");
		
		Fluxo flux = new Fluxo();
		flux.setNome("Fluxo 1");
		flux.setTipo("PRINCIPAL");
		flux.setCasoDeUso(caso);
		flux.setCodigo(1);
		
		Passo pa = new Passo();
		pa.setAcao("Modificar");
		pa.setAtor(ator);
		pa.setComplemento("Realizar a modificação da camada persistência");
		pa.setFluxo(flux);
		pa.setPontoDeExtensao(caso);
		pa.setCodigo(1);
		
		PosCondicao pos = new PosCondicao();
		pos.setDescricao("Fechar");
		pos.setCasoDeUso(caso);
		
		PreCondicao pre = new PreCondicao();
		pre.setDescricao("Estar Logado no Sistema");
		pre.setCasoDeUso(caso);
		
		RegraDeNegocio regra = new RegraDeNegocio();
		regra.setDescricao("Apresentar resultado da pesquisa: ");
		regra.setCasoDeUso(caso);
		
		RequisitoNaoFuncional req = new RequisitoNaoFuncional();
		req.setDescricao("O sistema deverá rodar em qualquer plataforma");
		req.setCasoDeUso(caso);
		
		projDao.gravar(projeto);
		atorDao.gravar(ator);
		casoDao.gravar(caso);
		fluxDao.gravar(flux);
		paDao.gravar(pa);
		posDao.gravar(pos);
		preDao.gravar(pre);
		regraDao.gravar(regra);
		reqDao.gravar(req);
		
	
	}
	
}
