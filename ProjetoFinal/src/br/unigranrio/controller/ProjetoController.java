package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.ProjetoDAO;

public class ProjetoController {
	
	ProjetoDAO dao = new ProjetoDAO();
	AtorController ator = new AtorController();
	
	public ProjetoController() {
	}
	
	public String gravar(Projeto projeto){
		String erro = null;
		List<Projeto> projetos = dao.retornarTodos();
		for (Projeto projeto2 : projetos) {
			if(projeto2.getNome().equals(projeto.getNome())){
				erro = "Projeto com mesmo nome já cadastrado";
				break;
			} else {
				erro = null;
			}
		}
		if (erro == null){
			dao.gravar(projeto);
			ator.atorSistema(projeto);
		}
		return erro;
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
	
	public List<Projeto> retornaTodos(){
		return dao.retornarTodos();
	}

}
