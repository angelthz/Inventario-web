package com.athz.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAccess implements Accion {

	@Override
	public Respuesta ejecutar(HttpServletRequest req, HttpServletResponse resp) {
		System.out.printf("Controller: LoginAccess\n\n");
		HttpSession session = req.getSession();
		boolean usuarioHasSession = session.getAttribute("usuario") != null;

		if(usuarioHasSession)
			return new Respuesta(Respuesta.REDIRECT, "?accion=ListarProducto");
		else
			return new Respuesta(Respuesta.DISPATCH, "login.jsp");
	}
	
}
