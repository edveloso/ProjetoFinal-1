package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.dao.impl.RequisitoNaoFuncionalDAO;

public class RequisitoNaoFuncionalController {
	
	private RequisitoNaoFuncionalDAO dao = new RequisitoNaoFuncionalDAO();
	
	public String gravar(Projeto projeto, RequisitoNaoFuncional req){
		String erro = null;
		List<RequisitoNaoFuncional> list = dao.retornarTodos();
		for (RequisitoNaoFuncional requisitoNaoFuncional2 : list){
			if(requisitoNaoFuncional2.getDescricao().equals(req.getDescricao())){
				erro = "Requisito não Funcional com a mesma descrição já cadastrada";
				break;
			}else {
				erro = null;
			}
		}
		if (erro == null){
			int numero = Integer.parseInt(dao.countItensParaCodigo(projeto.getId()));
			numero++;
			String codigo = "RNF"+numero;
			req.setCodigo(codigo);
			req.setProjeto(projeto);
			dao.gravar(req);
		}
		return erro;
	}
	
	public List<RequisitoNaoFuncional> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public List<RequisitoNaoFuncional> selecionaTodosPorProjeto(long id){
		return dao.selecionaTodosPorProjeto(id);
	}
	
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public String atualizar(RequisitoNaoFuncional req) {
		String erro = null;
		List<RequisitoNaoFuncional> list = dao.retornarTodos();
		for (RequisitoNaoFuncional requisitoNaoFuncional2 : list){
			if(requisitoNaoFuncional2.getDescricao().equals(req.getDescricao())){
				erro = "Requisito não Funcional com a mesma descrição já cadastrada";
				break;
			}else {
				erro = null;
			}
		}
		if (erro == null){
		dao.atualizar(req);
		}
		return erro;
	}
	
	public RequisitoNaoFuncional selecionaRequisitoPorId(long id){
		return (RequisitoNaoFuncional) dao.selecionaPorId(id);
	}

}
