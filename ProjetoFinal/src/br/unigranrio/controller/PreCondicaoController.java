package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.dao.impl.PreCondicaoDAO;

public class PreCondicaoController {
	
	private PreCondicaoDAO dao = new PreCondicaoDAO();
	
	public void gravar(CasoDeUso caso, PreCondicao pre){
		pre.setCasoDeUso(caso);
		dao.gravar(pre);
	}
	
	public List<PreCondicao> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
