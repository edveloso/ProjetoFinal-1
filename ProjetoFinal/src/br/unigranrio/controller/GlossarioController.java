package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Glossario;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.impl.GlossarioDAO;

public class GlossarioController {
	
	private GlossarioDAO dao = new GlossarioDAO();	
	
	public String gravar(Projeto projeto, Glossario glossario){
		String erro = null;
		List<Glossario> glossarios = dao.retornarTodos();
		for(Glossario glossario2 : glossarios){
			//Valida��o de Termo e Defini��o com o mesmo nome nom cadastro de gloss�rio
			if(glossario2.getSigla().equals(glossario.getSigla())){
				erro = "Termo com mesmo nome j� cadastrado";
				break;
			}else{
				erro=null;
			}
			if(glossario2.getDefinicao().equals(glossario.getDefinicao())){
				erro = "Defini��o com mesmo nome j� cadastrado";
				break;
			}else{
				erro=null;
			}
		}
		if (erro == null){
		//if (glossario.getDefinicao() != null){
			//dao.gravar(glossario);
		glossario.setProjeto(projeto);
		dao.gravar(glossario);
		}
		
		return erro;
	
	}
	
	public List<Glossario> selecionaTodosPorProjeto(long id){
		return dao.selecionaTodosPorProjeto(id);
	}
	
	public String atualizar(Glossario glossario){
		String erro = null;
		List<Glossario> glossarios = dao.retornarTodos();
		for (Glossario glossario2 : glossarios){
			//Valida��o de Termo e Defini��o com o mesmo nome nom cadastro de gloss�rio
			if(glossario2.getSigla().equals(glossario.getSigla())){
				erro = "Termo com mesmo nome j� cadastrado";
				break;
			}else{
				erro=null;
			}
			if(glossario2.getDefinicao().equals(glossario.getDefinicao())){
				erro = "Defini��o com mesmo nome j� cadastrado";
				break;
			}else{
				erro = null;
			}
		}if (erro == null){
			dao.atualizar(glossario);
		}
		return erro;
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public Glossario selecionarGlossario(long id){
		return (Glossario) dao.selecionaPorId(id);
	}

}

