package com.athz.servlets.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.athz.dao.DaoProducto;
import com.athz.dto.ProductoDTO;
import com.athz.jpa.entities.Producto;
import com.athz.jpa.utils.EmFactory;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/service-productos")
public class ProductoServiceServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto daoProductos = new DaoProducto(em);
		Gson gson = new Gson();
		
		List<ProductoDTO> productos = new ArrayList<>();
		
		daoProductos.getProductos().forEach(prod->{
			productos.add(new ProductoDTO(prod));
		});
		
		em.close();
		
		String produtosJson = gson.toJson(productos);
		resp.setContentType("Application/json");
		resp.getWriter().print(produtosJson);
		
	}
	
	
}
