<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Producto Nuevo</title>
</head>
<body>
	<form action="guardar-producto" method="POST">
		<label for="product">Nombre: </label>
		<input type="text" name="nombre" id="product" placeholder="Ingresa el nombre...">
		<br>
		<label for="category">Categorias: </label>
			<select name="categoria" id="category" >
				<option value="" selected disabled>Elije una categoria</option>
				<c:forEach items="${categorias}" var="categoria">
					<option value="${categoria.getIdCategoria()}"> ${categoria.getNombre()} </option>
				</c:forEach>
			</select>
		<br>
		<label for="price">Precio: </label>
		<input type="text" name="precio" id="price" placeholder="0.00">
		<br>
		<label for="amount">Cantidad: </label>
		<input type="number" name="cantidad" id="amount" min="1">
		<br>
		<input type="submit" value="Enviar">	
	</form>
</body>
</html>