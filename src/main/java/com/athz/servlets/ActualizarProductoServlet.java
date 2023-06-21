package com.athz.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.athz.dao.DaoCategoria;
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

@WebServlet (urlPatterns = "/actualizar-producto")
public class ActualizarProductoServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto productoDao = new DaoProducto(em);
		
		//object
		Integer id = Integer.valueOf(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		BigDecimal precio = new BigDecimal(req.getParameter("precio"));
		Integer cantidad = Integer.valueOf(req.getParameter("cantidad"));
		Integer idCatego = Integer.valueOf(req.getParameter("categoria"));
		Categoria categoria = em.find(Categoria.class, idCatego);
		
		Producto prod = new Producto(id, categoria, nombre, precio, cantidad);
		productoDao.upadteProducto(prod);
		
		resp.sendRedirect("listar-productos");
	}
}
