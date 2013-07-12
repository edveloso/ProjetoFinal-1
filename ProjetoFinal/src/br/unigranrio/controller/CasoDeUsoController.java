package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.dao.impl.CasoDeUsoDAO;

public class CasoDeUsoController {
	
	private CasoDeUsoDAO dao = new CasoDeUsoDAO();
	
	public String gravar(CasoDeUso caso){
		String erro = null;
		List<CasoDeUso> casosDeUso = dao.retornarTodos();
		for (CasoDeUso caso2 : casosDeUso){
			if(caso2.getNome().equals(caso.getNome())){
				erro = "Caso de Uso com o mesmo nome já cadastrado";
				break;
			}else{
				erro = null;
			}
		}
		if (erro == null ){
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
		return erro;
	}
	
	public String atualizar(CasoDeUso caso){
		String erro = null;
		List<CasoDeUso> casosDeUso = dao.retornarTodos();
		for (CasoDeUso caso2 : casosDeUso){
			if(caso2.getNome().equals(caso.getNome())){
				erro = "Caso de Uso com o mesmo nome já cadastrado";
				break;
			}else{
				erro = null;
			}
		}
		if (erro == null ){
			dao.atualizar(caso);
		}
		return erro;
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
