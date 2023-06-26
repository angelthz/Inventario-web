package com.athz.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.athz.dao.DaoProducto;
import com.athz.jpa.entities.Categoria;
import com.athz.jpa.entities.Producto;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuardarProducto implements Accion {

	@Override
	public Respuesta ejecutar(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Ejecutando el servlet: "+this.getClass().getSimpleName());
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto daoProducto = new DaoProducto(em);
		
		String nombre = req.getParameter("nombre");
		
		Integer idCat = Integer.valueOf(req.getParameter("categoria"));
		Categoria catego = em.find(Categoria.class, idCat);
		
		Integer cantidad = Integer.valueOf(req.getParameter("cantidad"));
		BigDecimal precio = new BigDecimal(req.getParameter("precio"));
		
		Producto prod = new Producto(catego,nombre, precio, cantidad);
		System.out.println("Producto: {"+ catego+", "+nombre+", "+precio+", "+cantidad+"}");
		
		daoProducto.saveProducto(prod);
		em.close();
		return new Respuesta(Respuesta.REDIRECT, "?accion=ListarProducto");
	}

}
