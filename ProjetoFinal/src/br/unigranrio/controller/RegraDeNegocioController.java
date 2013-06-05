package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.impl.RegraDeNegocioDAO;

public class RegraDeNegocioController {
	
	private RegraDeNegocioDAO dao = new RegraDeNegocioDAO();
	
	public void gravar(/*CasoDeUso caso,*/ Projeto projeto, RegraDeNegocio regra){
		//regra.setCasoDeUso(caso);
		int numero = Integer.parseInt(dao.countItensParaCodigo(projeto.getId()));
		numero++;
		String codigo = "RN"+numero;
		regra.setCodigo(codigo);
		regra.setProjeto(projeto);
		dao.gravar(regra);
	}
	
	public List<RegraDeNegocio> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public List<RegraDeNegocio> selecionaTodosPorProjeto(long id){
		return dao.selecionaTodosPorProjeto(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
