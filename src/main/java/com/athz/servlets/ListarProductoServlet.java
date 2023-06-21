package com.athz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;

import com.athz.dao.DaoCategoria;
import com.athz.dao.DaoProducto;
import com.athz.jpa.entities.Categoria;
import com.athz.jpa.entities.Producto;
import com.athz.jpa.utils.EmFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/listar-productos")
public class ListarProductoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Al hacer un redireccionamiento desde el cliente se evita
		//que al actualizar la pagina se vuelvan a enviar los datos
		//ingresados en formularios
		EntityManager em = EmFactory.getEntityManager();
		DaoProducto daoProductos = new DaoProducto(em);
		DaoCategoria daoCategorias = new DaoCategoria(em);
		
		List<Producto> productos = daoProductos.getProductos();
		List<Categoria> categorias = daoCategorias.getCategorias();
		
		RequestDispatcher reqDis = req.getRequestDispatcher("/productos.jsp");
		req.setAttribute("productos", productos);
		req.setAttribute("categorias", categorias);
		reqDis.forward(req, resp);
		
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<ul>");
//		daoProductos.getProductos().forEach(producto -> {
//			out.println("<li>" +producto.getNombre()+ "</li>");
//		});
//		out.println("</ul>");
//		out.println("</body>");
//		out.println("</html>");
		
	}
}
