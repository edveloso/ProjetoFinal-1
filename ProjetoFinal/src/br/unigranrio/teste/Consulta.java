package br.unigranrio.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.dao.HibernateUtil;

public class Consulta {
	
	Session session = HibernateUtil.getSession();
		
	public List<Object[]> consultaCasoDeUso(long id){
		Query qry = session.createSQLQuery("select * from casodeuso cu, ator a, casodeusoator cua, fluxo f, passo p " +
											" where cu.projeto_id = :id and " +
											" cu.casoDeUso_id = cua.casoDeUso_id and" +
											" cua.ator_id = a.ator_id and" +
											" cu.casoDeUso_id = f.casoDeUso_casoDeUso_id and" +
											" f.id = p.idFluxo").setParameter("id", id);
		List<Object[]> casos = qry.list();
		return casos; 
	}

}
