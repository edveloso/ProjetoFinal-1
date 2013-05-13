package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.dao.impl.RequisitoNaoFuncionalDAO;

public class RequisitoNaoFuncionalController {
	
	private RequisitoNaoFuncionalDAO dao = new RequisitoNaoFuncionalDAO();
	
	public void gravar(CasoDeUso caso, RequisitoNaoFuncional req){
		req.setCasoDeUso(caso);
		dao.gravar(req);
	}
	
	public List<RequisitoNaoFuncional> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
