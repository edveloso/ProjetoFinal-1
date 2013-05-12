package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUsoAtor;
import br.unigranrio.dao.impl.CasoDeUsoAtorDAO;

public class CasoDeUsoAtorController {

	private CasoDeUsoAtorDAO dao = new CasoDeUsoAtorDAO();
	
	public List<CasoDeUsoAtor> selecionarTodosPorCaso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
}
