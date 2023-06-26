package com.athz.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmFactory {
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("inventario");

	
	public static EntityManager getEntityManager() {

		return FACTORY.createEntityManager();
	}
}
