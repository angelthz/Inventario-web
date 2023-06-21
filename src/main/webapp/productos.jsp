<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventario de Productos</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header class="header">
	</header>
	
	<div class="table-container">
      <table>
        <thead>
          <tr>
            <th >ID</th>
            <th >Nombre</th>
            <th >Precio</th>
            <th >Cantidad</th>
            <th>Categoria</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${productos}" var="producto">
	          <tr>
	          <td>${producto.getIdProducto() }</td>
	            <td>${ producto.getNombre() }</td>
	            <td>$ ${ producto.getPrecio() }</td>
	            <td>${ producto.getCantidad() }</td>
	            <td>${ producto.getCategoria().getNombre() }</td>
	            <td class="row-btns">
	              <button id="edit-btn" 
		              	data-id="${producto.getIdProducto()}"
		              	data-nombre="${producto.getNombre()}"
		              	data-precio="${ producto.getPrecio() }"
		              	data-cantidad="${ producto.getCantidad() }"
	              	">Editar</button>
	              <button id="delete-btn" 
	              		data-id="${producto.getIdProducto()}"
		              	data-nombre="${producto.getNombre()}"
	              >Borrar</button>
	            </td>
	          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    
    <div class="add-product hidden">
    	<button id="new-product-btn">Registrar Producto</button>
    </div>
    
	<div class="forms-container hidden">
		<form  action="guardar-producto" method="POST" class="save-producto-form hidden">
			<input type="hidden" name="id" value="">
			<label for="name" >Nombre</label>
			<input type="text" name="nombre" id="name" required>
			<label for="price">Precio</label>
			<input type="text" name="precio" id="price" required>
			<label for="amount">Cantidad</label>
			<input type="number" name="cantidad" id="amount" required>
			<label for="category">Categorias: </label>
			<select name="categoria" id="category"  required>
				<option value="" selected disabled>Elije una categoria</option>
				<c:forEach items="${categorias}" var="categoria">
					<option value="${categoria.getIdCategoria()}"> ${categoria.getNombre()} </option>
				</c:forEach>
			</select>
			<input type="submit" value="Guardar" id="save-product">
		</form>
		<form class="delete-product-form hidden" action="eliminar-producto" method="POST">
			<h3>¿Desea eliminar el siguiente producto?</h3>
			<h4 id="product-name">name</h4>
			<div class="input-container">
				<input name="id" type="hidden" value="">
				<input name="nombre" type="hidden" value="">
				<input type="submit" value="Si">
				<input type="button" value="No" id="cancel-delete-btn">
			</div>
		</form>
	</div>
	<div class="delete-container-form hidden ">
		
	</div>
	
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>