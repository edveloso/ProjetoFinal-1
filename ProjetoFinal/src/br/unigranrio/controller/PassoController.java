package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.dao.impl.PassoDAO;

public class PassoController {
	
	PassoDAO dao = new PassoDAO();
	
	public PassoController() {
	}
	
	public void gravar(Passo passo){
		int numero = Integer.parseInt(dao.countItensParaCodigo(passo.getFluxo().getId()));
		numero++;
		String codigo = "P"+numero;
		passo.setCodigo(codigo);
		dao.merge(passo);
	}
	
	public void atualizar(Passo passo) {
		dao.atualizar(passo);
	}

	public void remover(long id) {
		dao.removerPorId(id);
	}

	public List<Passo> selecionarTodosFluxo(long id){
		return dao.retornaPorFluxo(id);
	}
}
