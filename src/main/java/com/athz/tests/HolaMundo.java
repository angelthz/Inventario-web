package com.athz.tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//anotaciones para tomcat 7.0+
@WebServlet(urlPatterns = "/saludar")
public class HolaMundo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String res ="<html><body><h1>Soy un String</h1></body></html>";
		PrintWriter out = resp.getWriter();
		out.print(res); 
 		 out.println("<html>");
//		 out.println("<body>");
//		 out.println("<h1>");
//		 out.println("Soy un Servlet Java");
//		 out.println("</h1>");
//		 out.println("</body>");
//		 out.println("</html>");
		 
	}
}
