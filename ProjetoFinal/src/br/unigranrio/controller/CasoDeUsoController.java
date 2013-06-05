package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.dao.impl.CasoDeUsoDAO;

public class CasoDeUsoController {
	
	private CasoDeUsoDAO dao = new CasoDeUsoDAO();
	
	public void gravar(CasoDeUso caso){
		if (caso.getNome() != null){
			int codigo = Integer.parseInt(dao.countItensParaCodigo(caso.getProjeto().getId()));
			codigo++;
			if(codigo<10){
				caso.setCodigo("UC00"+codigo);
			} else if(codigo <100 && codigo>9){
				caso.setCodigo("UC0"+codigo);
			} else if(codigo > 99){
				caso.setCodigo("UC"+codigo);
			}
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
