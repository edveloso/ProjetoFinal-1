package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.dao.impl.CasoDeUsoDAO;

public class CasoDeUsoController {
	
	private CasoDeUsoDAO dao = new CasoDeUsoDAO();
	
	public void gravar(CasoDeUso caso){
		if (caso.getNome() != null){
			String codigo = caso.getCodigo();
			caso.setCodigo("UC"+codigo);
			dao.gravar(caso);
		}
	}
	
	public void atualizar(CasoDeUso caso){
		dao.atualizar(caso);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public CasoDeUso selecionarCaso(long id){
		return (CasoDeUso) dao.selecionaPorId(id);
	}

	public List<CasoDeUso> selecionarTodosProjeto(long id){
		return dao.retornaPorProjeto(id);
	}
	
}
