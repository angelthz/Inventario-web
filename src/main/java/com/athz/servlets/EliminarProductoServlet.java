package com.athz.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.athz.dao.DaoProducto;
import com.athz.jpa.entities.Categoria;
import com.athz.jpa.entities.Producto;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/eliminar-producto")
public class EliminarProductoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto daoProducto = new DaoProducto(em);
		
		Integer idProducto = Integer.valueOf(req.getParameter("id"));
		daoProducto.deleteProducto(idProducto);
		
		resp.sendRedirect("listar-productos");
	}
}
