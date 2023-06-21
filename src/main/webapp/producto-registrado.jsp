<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto Registrado</title>
</head>
<body>
	<h3>Se registro el producto con exito </h3>
	<ul>
		<li>Nombre: ${producto.getNombre()} </li>
		<li>Precio: ${producto.getPrecio()}</li>
	</ul>
</body>
</html>