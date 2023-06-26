package com.athz.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginClose implements Accion{

	@Override
	public Respuesta ejecutar(HttpServletRequest req, HttpServletResponse resp) {
		System.out.printf("Controller: LoginClose\n\n");
		HttpSession session = req.getSession();
		session.invalidate();
		return new Respuesta(Respuesta.REDIRECT, "?accion=LoginAccess");
	}
	
}
