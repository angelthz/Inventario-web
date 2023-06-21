package com.athz.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import com.athz.dao.DaoCategoria;
import com.athz.jpa.entities.Categoria;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/nuevo-producto")
public class NuevoProductoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = EmFactory.getEntityManager();
		DaoCategoria daoCategorias = new DaoCategoria(em);
		List<Categoria> categorias;
		categorias = daoCategorias.getCategorias();
		
		RequestDispatcher rd = req.getRequestDispatcher("registrar-producto.jsp");
		req.setAttribute("categorias", categorias);
		rd.forward(req, resp);
	}
}
