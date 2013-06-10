package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Glossario;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.impl.GlossarioDAO;

public class GlossarioController {
	
	private GlossarioDAO dao = new GlossarioDAO();	
	
	public void gravar(Projeto projeto, Glossario glossario){
		//if (glossario.getDefinicao() != null){
			//dao.gravar(glossario);
		glossario.setProjeto(projeto);
		dao.gravar(glossario);
	
	}
	
	public List<Glossario> selecionaTodosPorProjeto(long id){
		return dao.selecionaTodosPorProjeto(id);
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

}

