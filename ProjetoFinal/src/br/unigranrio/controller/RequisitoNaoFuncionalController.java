package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.dao.impl.RequisitoNaoFuncionalDAO;

public class RequisitoNaoFuncionalController {
	
	private RequisitoNaoFuncionalDAO dao = new RequisitoNaoFuncionalDAO();
	
	public void gravar(Projeto projeto, RequisitoNaoFuncional req){
	//public void gravar(CasoDeUso caso, RequisitoNaoFuncional req){
		//req.setCasoDeUso(caso);
		//dao.gravar(req);
		int numero = Integer.parseInt(dao.countItensParaCodigo(projeto.getId()));
		numero++;
		String codigo = "RNF"+numero;
		req.setCodigo(codigo);
		req.setProjeto(projeto);
		dao.gravar(req);
	}
	
	public List<RequisitoNaoFuncional> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public List<RequisitoNaoFuncional> selecionaTodosPorProjeto(long id){
		return dao.selecionaTodosPorProjeto(id);
	}
	
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public void atualizar(RequisitoNaoFuncional req) {
		dao.atualizar(req);
	}
	
	public RequisitoNaoFuncional selecionaRequisitoPorId(long id){
		return (RequisitoNaoFuncional) dao.selecionaPorId(id);
	}

}
