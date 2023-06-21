package com.athz.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.athz.jpa.entities.Categoria;



public class DaoCategoria {
	private EntityManager em;
	
	public DaoCategoria(EntityManager em) {
		this.em = em;
	}
	
	public List<Categoria> getCategorias(){
		String jpql = "FROM Categoria";
		return this.em.createQuery(jpql, Categoria.class).getResultList();
	}
	
	
}
