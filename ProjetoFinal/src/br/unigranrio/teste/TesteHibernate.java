package br.unigranrio.teste;

import java.util.ArrayList;
import java.util.List;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.CasoDeUsoAtor;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.AtorDAO;
import br.unigranrio.dao.impl.CasoDeUsoAtorDAO;
import br.unigranrio.dao.impl.CasoDeUsoDAO;
import br.unigranrio.dao.impl.ProjetoDAO;

public class TesteHibernate {


	
	public static void main(String[] args) {
		ProjetoDAO projDao = new ProjetoDAO();
		AtorDAO atorDao = new AtorDAO();
		CasoDeUsoDAO casoDao = new CasoDeUsoDAO();
		CasoDeUsoAtorDAO casoAtorDao = new CasoDeUsoAtorDAO();
		
		Projeto proj = new Projeto();
		proj.setNome("Teste hibernate");
		Ator ator = new Ator();
		ator.setNome("Teste");
		ator.setProjeto(proj);
		List<Ator> atores = new ArrayList<Ator>();
		atores.add(ator);
		CasoDeUso caso = new CasoDeUso();
		caso.setCodigo("UC001");
		caso.setAtores(atores);
		caso.setProjeto(proj);
		CasoDeUsoAtor casoAtor = new CasoDeUsoAtor();
		casoAtor.setAtor(ator);
		casoAtor.setCasoDeUso(caso);
		casoAtor.setTipoAtor("Primario");
		projDao.gravar(proj);
		atorDao.gravar(ator);
		casoDao.gravar(caso);
		casoAtorDao.gravar(casoAtor);
		
	}
	
}
