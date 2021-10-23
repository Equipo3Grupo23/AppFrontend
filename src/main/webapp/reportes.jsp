<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Principal</title>


</head>
<body>
	<div class="container-fluid">

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
			<a class="navbar-brand" href="principal.jsp">Tienda Virtual</a>
		</nav>

		<header id="header"
			class="d-flex align-items-center  header-transparent ">

			<div
				class="container d-flex align-items-center justify-content-between">
				<ul class="nav nav-pills nav-fill">
					<li class="nav-item"><a class="nav-link" href="principal.jsp">Menu
							principal</a></li>
					<li class="nav-item"><a class="nav-link"
						href="adminUsuarios.jsp">Usuarios</a></li>
					<li class="nav-item"><a class="nav-link"
						href="adminClientes.jsp">Clientes</a></li>
					<li class="nav-item"><a class="nav-link"
						href="adminProveedores.jsp">Proveedores</a></li>
					<li class="nav-item"><a class="nav-link" href="adminProductos.jsp">Productos</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="adminVentas.jsp">Ventas</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="reportes.jsp">Reportes</a></li>
				</ul>
			</div>
		</header>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-4">
				<form method="get" action="./UsuariosServlet">
					<div class="form-group row">
						<button type="submit" class="btn btn-primary btn-lg"
							value="listar" name="tipo">Lista de Usuarios</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<form method="get" action="./ClientesServlet">
					<div class="form-group row">
						<button type="submit" class="btn btn-primary btn-lg"
							value="listar" name="tipo">Lista de Clientes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>