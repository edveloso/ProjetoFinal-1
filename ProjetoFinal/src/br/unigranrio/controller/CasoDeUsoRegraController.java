package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUsoRegra;
import br.unigranrio.dao.impl.CasoDeUsoRegraDAO;

public class CasoDeUsoRegraController {

	private CasoDeUsoRegraDAO dao = new CasoDeUsoRegraDAO();
	
	public List<CasoDeUsoRegra> selecionarTodosPorCaso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public String gravar(CasoDeUsoRegra casoRegra){
		String erro = null;
		try {
			dao.merge(casoRegra);
		} catch (Exception e) {
			erro = e.toString();
		}
		return erro;
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public void removerObj(CasoDeUsoRegra casoRegra){
		dao.remover(casoRegra);
	}
	
}
