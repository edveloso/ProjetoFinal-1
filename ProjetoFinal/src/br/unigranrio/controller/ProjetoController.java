package br.unigranrio.controller;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.ProjetoDAO;

public class ProjetoController {
	
	ProjetoDAO dao = new ProjetoDAO();
	AtorController ator = new AtorController();
	
	public ProjetoController() {
	}
	
	public void gravar(Projeto projeto){
		if (projeto.getNome() != null){
			dao.gravar(projeto);
			ator.atorSistema(projeto);
		}
	}
	
	public void atualizar(Projeto projeto){
		dao.atualizar(projeto);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public Projeto selecionarProjeto(long id){
		return (Projeto) dao.selecionaPorId(id);
	}

}
