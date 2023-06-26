package com.athz.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Accion {
	public Respuesta ejecutar(HttpServletRequest req, HttpServletResponse resp);
}
