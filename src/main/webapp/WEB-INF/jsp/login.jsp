<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Inicia sesion</title>
</head>
<body class="login">

	<div class="sesion-container">
		<header class="login-header">
			<h2>Login</h2>
		</header>			
		<form class="login-body" action="entrada" method="POST">
			<input type="hidden" name="accion" value="LoginValidation">
			
			<label for="user">Usuario</label>
			<input type="text" name="usuario" id="user" required>
			
			<label for="password">Contraseña</label>
			<input type="password" name="password" id="password" required>
			
			<input type="submit" value="Iniciar sesion">
		</form>
	</div>
</body>
</html>