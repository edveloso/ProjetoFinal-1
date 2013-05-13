package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.FluxoDAO;

public class FluxoController {
	
	FluxoDAO dao = new FluxoDAO();
	
	public FluxoController() {
	}
	
	public void gravar(Fluxo fluxo){
		dao.gravar(fluxo);
	}
	
	public void atualizar(Fluxo fluxo) {
		dao.atualizar(fluxo);

	}

	public void remover(long id) {
		dao.removerPorId(id);
	}

	public List<Fluxo> selecionarTodosCaso(long id){
		return dao.retornaPorCaso(id);
	}
}
