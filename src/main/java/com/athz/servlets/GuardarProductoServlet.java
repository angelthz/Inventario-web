package com.athz.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.athz.dao.DaoProducto;
import com.athz.jpa.entities.Categoria;
import com.athz.jpa.entities.Producto;
import com.athz.jpa.utils.EmFactory;

/**
 * Servlet implementation class AgregarProductoServlet
 */
public class GuardarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ejecutando el servlet: "+this.getClass().getSimpleName());
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto daoProducto = new DaoProducto(em);
		
		String nombre = request.getParameter("nombre");
		
		Integer idCat = Integer.valueOf(request.getParameter("categoria"));
		Categoria catego = em.find(Categoria.class, idCat);
		
		Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
		BigDecimal precio = new BigDecimal(request.getParameter("precio"));
		
		Producto prod = new Producto(catego,nombre, precio, cantidad);
		System.out.println("Producto: {"+ catego+", "+nombre+", "+precio+", "+cantidad+"}");
		
		daoProducto.saveProducto(prod);
//		
//		PrintWriter out = response.getWriter();
//		out.println("<h2>Producto registrado</h2>");
		
		
//		String nombre = request.getParameter("nombre");
//		Integer idCat = Integer.valueOf(request.getParameter("categoria"));
//		Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
//		BigDecimal precio = new BigDecimal(request.getParameter("precio"));
//		
//		Producto prod = new Producto(idCat, nombre, cantidad, precio);
		
		//redirigiendo a un JSP server side
//		RequestDispatcher reqDispatcher = 
//				request.getRequestDispatcher("/producto-registrado.jsp");
//		request.setAttribute("producto", prod);
//		reqDispatcher.forward(request, response);
		
		//redireccionando cliente side
		//el cliente solicita este serlvet AgregarProducto
		//el servidor responde con una redireccion a otro servlet ListarProducto
		//el cliente recibe la respuesta y solicita el servlet que
		//le fue enviado como respuesta
		response.sendRedirect("listar-productos");
	}

}
