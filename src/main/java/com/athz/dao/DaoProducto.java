package com.athz.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.athz.jpa.entities.Producto;


public class DaoProducto {
	private EntityManager em;
	
	public DaoProducto(EntityManager em) {
		this.em = em;
	}
	
	public List<Producto> getProductos(){
		String jpql = "FROM Producto";
		return this.em.createQuery(jpql, Producto.class).getResultList();
	}
	
	public void saveProducto(Producto prod) {
		try {
			this.em.getTransaction().begin();
				this.em.persist(prod);
			this.em.getTransaction().commit();
		}
		catch (Exception e) {
			this.em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteProducto(Integer id) {
		try {
			this.em.getTransaction().begin();
				Producto c = this.em.find(Producto.class, id);
				this.em.remove(c);
			this.em.getTransaction().commit();
		}
		catch(Exception e) {
			this.em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
	}
	
	public void upadteProducto(Producto p) {
		try {
			this.em.getTransaction().begin();
				this.em.merge(p);
			this.em.getTransaction().commit();
		}
		catch(Exception e) {
			this.em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
	}
}
