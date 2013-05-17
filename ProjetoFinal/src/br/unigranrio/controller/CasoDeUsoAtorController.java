package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.CasoDeUsoAtor;
import br.unigranrio.dao.impl.CasoDeUsoAtorDAO;

public class CasoDeUsoAtorController {

	private CasoDeUsoAtorDAO dao = new CasoDeUsoAtorDAO();
	
	public List<CasoDeUsoAtor> selecionarTodosPorCaso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public String gravar(CasoDeUsoAtor casoAtor){
		String erro = null;
		try {
			dao.merge(casoAtor);
		} catch (Exception e) {
			erro = e.toString();
		}
		return erro;
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public void removerObj(CasoDeUsoAtor casoAtor){
		dao.remover(casoAtor);
	}
	
}
