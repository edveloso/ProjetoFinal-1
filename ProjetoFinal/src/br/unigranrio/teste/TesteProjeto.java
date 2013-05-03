package br.unigranrio.teste;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.ProjetoDAO;

public class TesteProjeto {

	public static void main(String[] args) {
		Projeto projeto = new Projeto();
		ProjetoDAO dao = new ProjetoDAO();
		
		projeto.setNome("teste");
		dao.gravar(projeto);
	}
	
}
