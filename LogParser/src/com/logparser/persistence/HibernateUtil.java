package com.logparser.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static final String PERSISTENCE_UNIT_NAME = "parserDB";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}

	public static EntityManager getEntityManager() {
		return HibernateUtil.getEntityManagerFactory().createEntityManager();
	}

	public static void main(String[] args) {
		System.out.println(HibernateUtil.getEntityManagerFactory().createEntityManager());
		HibernateUtil.shutdown();
	}
}
