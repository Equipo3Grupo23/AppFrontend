<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Usuarios"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Nueva Tienda Virtual</title>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
			<a class="navbar-brand" href="principal.jsp">Tienda Virtual</a>
		</nav>
	</div>
	<header id="header"
		class="d-flex align-items-center  header-transparent ">

		<div
			class="container d-flex align-items-center justify-content-between">
			<ul class="nav nav-pills nav-fill">
				<li class="nav-item"><a class="nav-link" href="principal.jsp">Menu
						principal</a></li>
				<li class="nav-item"><a class="nav-link"
					href="adminUsuarios.jsp">Usuarios</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="adminClientes.jsp">Clientes</a></li>
				<li class="nav-item"><a class="nav-link"
					href="adminProveedores.jsp">Proveedores</a></li>
				<li class="nav-item"><a class="nav-link" href="adminProductos.jsp">Productos</a>
				</li>
				<li class="nav-item"><a class="nav-link "
					href="adminVentas.jsp">Ventas</a></li>
				<li class="nav-item"><a class="nav-link" href="reportes.jsp">Reportes</a>
				</li>
			</ul>
		</div>
	</header>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<form method="get" action="./ClientesServlet">
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Nombre</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								name="nombre">
						</div>
					</div>

					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Cedula</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								name="cedula">
						</div>
					</div>

					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								name="email">
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">Telefono</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputPassword3"
								name="telefono">
						</div>
					</div>

					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Direccion</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								name="direccion">
						</div>
					</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-4">

				<button type="submit" class="btn btn-primary btn-lg" value="agregar"
					name="tipo">Agregar</button>

				<button type="submit" class="btn btn-primary btn-lg" value="borrar"
					name="tipo">Borrar</button>
			</div>
		</div>
	</div>
	</form>


	<div class="input-group mb-3">
		<div class="col-md-2"></div>
		<div class="input-group-prepend">

			<form method="get" action="./ClientesServlet">
				<input type="hidden" name="tipo" value="buscar" /> <input
					type="text" class="form-control" name="txtcedula"
					placeholder="Cedula" aria-label="Cedula"
					aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit">Buscar</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>