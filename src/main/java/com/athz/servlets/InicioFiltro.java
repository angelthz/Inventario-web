package com.athz.servlets;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;	

//@WebFilter(urlPatterns = "/entrada")
public class InicioFiltro implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.printf("2. Filtro de Inicio: %s \n",request.getParameter("accion"));
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		boolean usuarioHasNotSesion = session.getAttribute("usuario") == null;
		
		if(request.getParameter("accion") == null && usuarioHasNotSesion) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("accion") == null && !usuarioHasNotSesion) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("?accion=ListarProducto");
		}
		else {
			chain.doFilter(request, response);
		}
	}

}
