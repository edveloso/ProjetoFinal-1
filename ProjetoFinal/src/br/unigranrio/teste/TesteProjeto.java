package br.unigranrio.teste;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.enums.TipoAtor;
import br.unigranrio.dao.impl.AtorDAO;
import br.unigranrio.dao.impl.ProjetoDAO;

public class TesteProjeto {

	public static void main(String[] args) {
		
		ProjetoDAO projDao = new ProjetoDAO();
		AtorDAO atorDao = new AtorDAO();
		
		Projeto projeto = new Projeto();
		projeto.setNome("primeiro");
		
		Ator ator = new Ator();
		ator.setNome("Joao");
		ator.setProjeto(projeto);
		ator.setTipo(TipoAtor.SECUNDARIO);
		
		projDao.gravar(projeto);
		atorDao.gravar(ator);
	}
	
}
