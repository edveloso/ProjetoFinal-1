package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.AtorDAO;

public class AtorController {
	
	AtorDAO dao = new AtorDAO();
	
	public void gravar(Ator ator, Projeto projeto){
		
		List<Ator> atores = dao.retornarTodos();
		for (Ator ator2 : atores) {
			if(ator2.getNome() == ator.getNome()){
				break;
			}
		}
		if(ator.getNome().length() > 20){
			System.out.println("Nome muito grande");
		} else {
			ator.setProjeto(projeto);
			dao.gravar(ator);
		}
		
	}
	
	public void atualizar(Ator ator) {
		long id = ator.getId();
		Ator atorAnterior = (Ator) dao.selecionaPorId(id);
		dao.atualizar(ator);

	}

	public void remover(long id) {
		dao.removerPorId(id);
	}
	
	public void atorSistema(Projeto projeto){
		Ator atorSistema = new Ator();
		atorSistema.setNome("Sistema");
		atorSistema.setProjeto(projeto);
		dao.gravar(atorSistema);
	}
}
