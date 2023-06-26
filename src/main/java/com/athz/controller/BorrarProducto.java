package com.athz.controller;

import javax.persistence.EntityManager;

import com.athz.dao.DaoProducto;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrarProducto implements Accion{

	@Override
	public Respuesta ejecutar(HttpServletRequest req, HttpServletResponse resp) {
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto daoProducto = new DaoProducto(em);
		
		Integer idProducto = Integer.valueOf(req.getParameter("id"));
		daoProducto.deleteProducto(idProducto);
		em.close();
		return new Respuesta(Respuesta.REDIRECT, "?accion=ListarProducto");
	}

}
