package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.AtorDAO;

public class AtorController {
	
	AtorDAO dao = new AtorDAO();
	
	public AtorController() {
	}
	
	public String gravar(Ator ator, Projeto projeto){
		String erro = null;
		List<Ator> atores = dao.retornarTodos();
		for (Ator ator2 : atores) {
			if(ator2.getNome().equals(ator.getNome())){
				erro = "Ator já cadastrado";
				break;
			} else {
				erro = null;
			}
		}
		if(erro == null){
			ator.setProjeto(projeto);
			dao.gravar(ator);
		}
		return erro;
	}
	
	public void atualizar(Ator ator) {
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
	
	public List<Ator> selecionarTodosProjeto(long id){
		return dao.retornaPorProjeto(id);
	}
	
	public Ator selecionaAtorPorId(long id){
		return (Ator) dao.selecionaPorId(id);
	}
}
