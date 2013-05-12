package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.dao.impl.PosCondicaoDAO;

public class PosCondicaoController {
	
	private PosCondicaoDAO dao = new PosCondicaoDAO();
	
	public void gravar(CasoDeUso caso, PosCondicao pos){
		pos.setCasoDeUso(caso);
		dao.gravar(pos);
	}
	
	public List<PosCondicao> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
