package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.impl.PosCondicaoDAO;

public class PosCondicaoController {
	
	private PosCondicaoDAO dao = new PosCondicaoDAO();
	
	public String gravar(PosCondicao pos){
		String erro =  null;
		List<PosCondicao> list = dao.retornarTodos();
		for (PosCondicao posCondicao2 : list){
			if(posCondicao2.getDescricao().equals(pos.getDescricao())){
				erro = "P�s-Condi��o com a mesma descri��o j� cadastrada";
				break;
			}else{
				erro = null;
			}
		}if (erro == null){
			int numero = Integer.parseInt(dao.countItensParaCodigo(pos.getCasoDeUso().getId()));
			numero++;
			String codigo = "POS"+numero;
			pos.setCodigo(codigo);
			dao.gravar(pos);	
		}
		return erro;
	}
	
	public String atualizar(PosCondicao pos) {
		String erro = null;
		List<PosCondicao> list = dao.retornarTodos();
		for (PosCondicao posCondicao2 : list){
			if(posCondicao2.getDescricao().equals(pos.getDescricao())){
				erro = "P�s-Condi��o com a mesma descri��o j� cadastrada";
				break;
			}else {
				erro = null;
			}
		}if(erro == null){
			dao.atualizar(pos);
		}
		return erro;

	}
	
	public List<PosCondicao> selecionaTodosPorCasoDeUso(long id){
		return dao.selecionaTodosPorCasoDeUso(id);
	}
	
	public void remover(long id){
		dao.removerPorId(id);
	}

}
