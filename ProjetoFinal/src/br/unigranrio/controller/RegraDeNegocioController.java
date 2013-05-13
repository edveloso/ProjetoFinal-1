package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.impl.RegraDeNegocioDAO;

public class RegraDeNegocioController {
	
	private RegraDeNegocioDAO dao = new RegraDeNegocioDAO();
	
	public void gravar(CasoDeUso caso, RegraDeNegocio regra){
		regra.setCasoDeUso(caso);
		dao.gravar(regra);
	}
	
	public List<RegraDeNegocio> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
