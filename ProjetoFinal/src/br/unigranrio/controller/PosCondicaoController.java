package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.impl.PosCondicaoDAO;

public class PosCondicaoController {
	
	private PosCondicaoDAO dao = new PosCondicaoDAO();
	
	public String gravar(CasoDeUso caso, PosCondicao pos){
		String erro =  null;
		List<PosCondicao> list = dao.retornarTodos();
		for (PosCondicao posCondicao2 : list){
			if(posCondicao2.getDescricao().equals(pos.getDescricao())){
				erro = "Pós-Condição com a mesma descrição já cadastrada";
				break;
			}else{
				erro = null;
			}
		}if (erro == null){
			pos.setCasoDeUso(caso);
			dao.gravar(pos);	
		}
		return erro;
	}
	
	public String atualizar(CasoDeUso caso, PosCondicao pos) {
		String erro = null;
		List<PosCondicao> list = dao.retornarTodos();
		for (PosCondicao posCondicao2 : list){
			if(posCondicao2.getDescricao().equals(pos.getDescricao())){
				erro = "Pós-Condição com a mesma descrição já cadastrada";
				break;
			}else {
				erro = null;
			}
		}if(erro == null){
			dao.atualizar(pos);
		}
		return erro;

	}
	
	public List<PosCondicao> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
