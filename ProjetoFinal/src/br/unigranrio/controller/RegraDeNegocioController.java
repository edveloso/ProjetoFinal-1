package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.impl.RegraDeNegocioDAO;

public class RegraDeNegocioController {
	
	private RegraDeNegocioDAO dao = new RegraDeNegocioDAO();
	
	public String gravar(Projeto projeto, RegraDeNegocio regra){
		String erro = null;
		List<RegraDeNegocio> list = dao.retornarTodos();
		for (RegraDeNegocio regraDeNegocio2 : list){
			if(regraDeNegocio2.getDescricao().equals(regra.getDescricao())){
				erro = "Regra de Negócio com a mesma descrição já cadastrada";
				break;
			}else {
				erro = null;
			}
		}if(erro == null){
			int numero = Integer.parseInt(dao.countItensParaCodigo(projeto.getId()));
			numero++;
			String codigo = "RN"+numero;
			regra.setCodigo(codigo);
			regra.setProjeto(projeto);
			dao.gravar(regra);
		}
		return erro;
		
	}
	
	public List<RegraDeNegocio> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public List<RegraDeNegocio> selecionaTodosPorProjeto(long id){
		return dao.selecionaTodosPorProjeto(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}
	
	public String atualizar(RegraDeNegocio regra) {
		String erro = null;
		List<RegraDeNegocio> list = dao.retornarTodos();
		for (RegraDeNegocio regraDeNegocio2 : list){
			if(regraDeNegocio2.getDescricao().equals(regra.getDescricao())){
				erro = "Regra de Negócio com a mesma descrição já cadastrada";
				break;
			}else {
				erro = null;
			}
		}if(erro == null){
			dao.atualizar(regra);
		}
		return erro;

	}
	
	public RegraDeNegocio selecionaRegraPorId(long id){
		return (RegraDeNegocio) dao.selecionaPorId(id);
	}

}
