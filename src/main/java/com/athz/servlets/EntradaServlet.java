package com.athz.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;

import com.athz.controller.Accion;
import com.athz.controller.ListarProducto;
import com.athz.controller.Respuesta;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/entrada")
@WebListener
public class EntradaServlet extends HttpServlet implements ServletContextListener{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.printf("Servlet: Entrada \n");
		String accion = req.getParameter("accion");
		Respuesta respuesta = null;

		//instacias en tiempo de ejecucion
		try {
			Class controllerClass = Class.forName("com.athz.controller."+accion);
			Accion controllerAction = (Accion) controllerClass.newInstance();
			respuesta = controllerAction.ejecutar(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		
		if(respuesta.getType().equals(Respuesta.DISPATCH)) {
			RequestDispatcher rd = req.getRequestDispatcher(
					"WEB-INF/jsp/"+respuesta.getAction());
			rd.forward(req, resp);
			
		}
		else if(respuesta.getType().equals(Respuesta.REDIRECT)) {
			
			resp.sendRedirect("entrada"+respuesta.getAction());
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		EmFactory.getEntityManager().close();
		System.out.printf("\n TERMINANDO APLICACION \n");
	}

}
