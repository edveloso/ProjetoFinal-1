package br.unigranrio.controller;

import java.util.List;

import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.dao.impl.FluxoDAO;

public class FluxoController {
	
	FluxoDAO dao = new FluxoDAO();
	
	public FluxoController() {
	}
	
	public String gravar(Fluxo fluxo){
		String erro = null;
		List<Fluxo> fluxos = dao.retornaPorCaso(fluxo.getCasoDeUso().getId());
		if(fluxo.getTipo().equals("Principal")){
			for (Fluxo fluxo2 : fluxos) {
				if(fluxo.getTipo().equals(fluxo2.getTipo())){
					erro = "Não se pode cadastrar mais de um fluxo do tipo 'Principal'";
					break;
				}
			}
		} else {
			String codigo = fluxo.getCodigo();
			fluxo.setCodigo("F"+codigo);
			dao.gravar(fluxo);
		}
		//dao.gravar(fluxo);
		return erro;
	}
	
	public void atualizar(Fluxo fluxo) {
		dao.atualizar(fluxo);

	}

	public void remover(long id) {
		dao.removerPorId(id);
	}

	public List<Fluxo> selecionarTodosCaso(long id){
		return dao.retornaPorCaso(id);
	}
}
