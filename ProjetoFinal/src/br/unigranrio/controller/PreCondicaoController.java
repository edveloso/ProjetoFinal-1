package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.dao.impl.PreCondicaoDAO;

public class PreCondicaoController {
	
	private PreCondicaoDAO dao = new PreCondicaoDAO();
	
	public String gravar(CasoDeUso caso, PreCondicao pre){
		String erro = null;
		List<PreCondicao> list = dao.retornarTodos();
		for (PreCondicao preCondicao2 : list){
			if(preCondicao2.getDescricao().equals(pre.getDescricao())){
				erro = "Pré-condição com a mesma descrição já cadastrada";
				break;
			} else {
				erro = null;
			}
		}
		if (erro == null){
			pre.setCasoDeUso(caso);
			dao.gravar(pre);	
		}
		return erro;
	}
	
	public List<PreCondicao> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
