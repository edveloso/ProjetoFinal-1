package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Glossario;
import br.unigranrio.dao.impl.GlossarioDAO;

public class GlossarioController {
	GlossarioDAO dao = new GlossarioDAO();
	
	public GlossarioController() {
	}
	
	public void gravar(Glossario glossario){
		if (glossario.getDefinicao() != null){
			dao.gravar(glossario);
		}
	}
	
	public void atualizar(Glossario glossario){
		dao.atualizar(glossario);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public Glossario selecionarGlossario(long id){
		return (Glossario) dao.selecionaPorId(id);
	}
	
	public List<Glossario> retornaTodos(){
		return dao.retornarTodos();
	}

}

