package com.athz.servlets;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter(urlPatterns = "/entrada")
public class LoginFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain chain) throws IOException, ServletException {
		System.out.printf("3. Filtro de Login\n");
		HttpServletRequest req = (HttpServletRequest) servletReq;
		HttpServletResponse resp = (HttpServletResponse) servletResp;
		HttpSession session = req.getSession();
		String accion = req.getParameter("accion");
		
		boolean usuarioHasNotSesion = session.getAttribute("usuario") == null;
		boolean accionNoPermitida = accion.equals("LoginAccess") || accion.equals("LoginValidation");

		if ( !accionNoPermitida && usuarioHasNotSesion )  {
			resp.sendRedirect("?accion=LoginAccess");
			return;
		}
		else
			chain.doFilter(req, resp);
	}

}
