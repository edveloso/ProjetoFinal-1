package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUsoRequisito;
import br.unigranrio.dao.impl.CasoDeUsoRequisitoDAO;

public class CasoDeUsoRequisitoController {

	private CasoDeUsoRequisitoDAO dao = new CasoDeUsoRequisitoDAO();
	
	public List<CasoDeUsoRequisito> selecionarTodosPorCaso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public String gravar(CasoDeUsoRequisito casoRequisito){
		String erro = null;
		try {
			dao.merge(casoRequisito);
		} catch (Exception e) {
			erro = e.toString();
		}
		return erro;
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public void removerObj(CasoDeUsoRequisito casoRequisito){
		dao.remover(casoRequisito);
	}
	
}
