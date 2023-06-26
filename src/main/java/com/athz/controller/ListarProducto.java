package com.athz.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.athz.dao.DaoCategoria;
import com.athz.dao.DaoProducto;
import com.athz.jpa.entities.Categoria;
import com.athz.jpa.entities.Producto;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarProducto implements Accion {
	@Override
	public Respuesta ejecutar(HttpServletRequest req, HttpServletResponse resp)  {
		System.out.printf("Controller: ListarProducto\n\n");
		
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto daoProductos = new DaoProducto(em);
		DaoCategoria daoCategorias = new DaoCategoria(em);
		List<Producto> productos = daoProductos.getProductos();
		List<Categoria> categorias = daoCategorias.getCategorias();
		em.close();
		
		req.setAttribute("productos", productos);
		req.setAttribute("categorias", categorias);
		
		return new Respuesta(Respuesta.DISPATCH, "productos.jsp");
	}
}
