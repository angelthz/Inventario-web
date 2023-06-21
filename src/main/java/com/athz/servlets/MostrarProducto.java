package com.athz.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/producto-nuevo")
public class MostrarProducto extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Como recibimos un redireccionamiento desde el 
		//servlet AgregarProducto lo que haremos ahora sera
		//responder con el JSP adecudo, con esto evitaremos
		//el reenvio del formulario al actualizar la pagina del mismo
		
		RequestDispatcher rd = req.getRequestDispatcher("producto-registrado.jsp");
		//req.setAttribute(LEGACY_DO_HEAD, rd);
	}
}
