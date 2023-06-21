package com.athz.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmFactory {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventario");
	
	public static EntityManager getEntityManager() {		
		return factory.createEntityManager();
	}
}
