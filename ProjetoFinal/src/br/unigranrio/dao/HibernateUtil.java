package br.unigranrio.dao;


public class HibernateUtil {
	
	private static SessionFactory factory;

	private static SessionFactory configureSessionFactory()	throws HibernateException {
		
		
	
	}

	public static SessionFactory getSessionFactory() {
		
		return configureSessionFactory();

	}
}
