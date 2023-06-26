package com.athz.controller;

import javax.persistence.EntityManager;

import com.athz.dao.DaoUsuario;
import com.athz.jpa.entities.Usuario;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginValidation implements Accion {

	@Override
	public Respuesta ejecutar(HttpServletRequest req, HttpServletResponse resp) {
		System.out.printf("Controller: LoginValidation\n\n");
		EntityManager em = EmFactory.getEntityManager();
		DaoUsuario daoUsuario = new DaoUsuario(em);
		
		String nombre = req.getParameter("usuario");
		String password = req.getParameter("password");
		
		String usuarioValido = daoUsuario.validateUserName(nombre);
		String passValido = daoUsuario.validateUserPass(nombre, password);
		
		em.close();
		
		if(usuarioValido!=null && passValido!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuarioValido);
			return new Respuesta(Respuesta.REDIRECT, "?accion=ListarProducto");
		}
		else {
			return new Respuesta(Respuesta.REDIRECT, "?accion=LoginAccess");
		}
	}

}
