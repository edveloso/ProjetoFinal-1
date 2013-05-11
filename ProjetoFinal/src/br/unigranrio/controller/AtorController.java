package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.AtorDAO;

public class AtorController {
	
	AtorDAO dao = new AtorDAO();
	
	public void gravar(Ator ator, Projeto projeto){
		List<Ator> atores = dao.retornarTodos();
		
		ator.setProjeto(projeto);
		
		
	}
	
	public void atualizar() {
		// TODO Auto-generated method stub

	}

	public void remover() {
		// TODO Auto-generated method stub

	}
	
	public void AtorSistema(Projeto projeto){
		Ator atorSistema = new Ator();
		atorSistema.setNome("Sistema");
		atorSistema.setProjeto(projeto);
		dao.gravar(atorSistema);
	}
}
