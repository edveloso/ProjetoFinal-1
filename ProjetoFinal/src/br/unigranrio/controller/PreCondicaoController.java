package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.dao.impl.PreCondicaoDAO;

public class PreCondicaoController {
	
	private PreCondicaoDAO dao = new PreCondicaoDAO();
	
	public String gravar(PreCondicao pre){
		String erro = null;
		List<PreCondicao> list = dao.retornarTodos();
		for (PreCondicao preCondicao2 : list){
			if(preCondicao2.getDescricao().equals(pre.getDescricao())){
				erro = "Pré-Condição com a mesma descrição já cadastrada";
				break;
			} else {
				erro = null;
			}
		}
		if (erro == null){
			int numero = Integer.parseInt(dao.countItensParaCodigo(pre.getCasoDeUso().getId()));
			numero++;
			String codigo = "PrC"+numero;
			pre.setCodigo(codigo);
			dao.gravar(pre);	
		}
		return erro;
	}
	
	public String atualizar(PreCondicao pre){
		String erro = null;
		List<PreCondicao> list = dao.retornarTodos();
		for (PreCondicao preCondicao2 : list){
			if(preCondicao2.getDescricao().equals(pre.getDescricao())){
				erro = "Pré-Condição com a mesma descrição já cadastrada";
				break;
			} else {
				erro = null;
			}
		}
		if (erro == null){
			dao.atualizar(pre);
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
