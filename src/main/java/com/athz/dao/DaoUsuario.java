package com.athz.dao;


import javax.persistence.EntityManager;

import com.athz.jpa.entities.Usuario;

public class DaoUsuario {
	private EntityManager em;
	
	public DaoUsuario(EntityManager em) {
		this.em = em;
	}
	

	public String validateUserName(String user) {
		String jpql = "SELECT user FROM Usuario AS user WHERE user.usuario=:user";
		Usuario result;
		
		try {
			result = this.em
					.createQuery(jpql, Usuario.class)
					.setParameter("user", user)
					.getSingleResult();
			return result.getUsuario();
		}
		catch (Exception e) {
			return null;
		}
		
		
	}
	
	public String validateUserPass(String user, String pass) {
		String jpql = "SELECT user FROM Usuario AS user WHERE user.usuario=:user AND user.pass=:pass";
		Usuario result;
		
		try {
			result = this.em
					.createQuery(jpql, Usuario.class)
					.setParameter("user", user)
					.setParameter("pass", pass)
					.getSingleResult();
			return result.getUsuario();
		}
		catch (Exception e) {
			return null;
		}
			
	}
}
