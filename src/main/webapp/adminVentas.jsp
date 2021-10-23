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
				<li class="nav-item"><a class="nav-link "
					href="adminUsuarios.jsp">Usuarios</a></li>
				<li class="nav-item"><a class="nav-link "
					href="adminClientes.jsp">Clientes</a></li>
				<li class="nav-item"><a class="nav-link "
					href="adminProveedores.jsp">Proveedores</a></li>
				<li class="nav-item"><a class="nav-link" href="adminProductos.jsp">Productos</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					href="adminVentas.jsp">Ventas</a></li>
				<li class="nav-item"><a class="nav-link" href="reportes.jsp">Reportes</a>
				</li>
			</ul>
		</div>
	</header>

	<div
		class="container">
		<form method="get" action="./VentasServlet">
			<input type="hidden" name="tipo" value="buscar_cli" />
			<div class="row">
				<div class="col-2">
					<input type="text" class="form-control" name="txtcedula"
						placeholder="Cedula" aria-label="Cedula"
						aria-describedby="basic-addon2">
					<!--  <div class="input-group-append">-->
					<button class="btn btn-primary" type="submit">Buscar</button>
					<!--  </div>-->
				</div>
				<div class="col-6">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("nombre2")%></output>
						<label class="col-sm-2 col-form-label">Cliente</label>
				</div>
				<div class="col-2">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("")%></output>
						<label class="col-sm-2 col-form-label">Consecutivo</label>
				</div>
			</div>
		</form>

	</div>


<div
		class="container">
		<form method="get" action="./VentasServlet">
			<input type="hidden" name="tipo" value="buscar_prod" />
			<div class="row">
				<div class="col-2">
					<input type="text" class="form-control" name="txtcodprod"
						placeholder="Codigo" aria-label="Codigo"
						aria-describedby="basic-addon2">
					<!--  <div class="input-group-append">-->
					<button class="btn btn-primary" type="submit">Consultar</button>
					<!--  </div>-->
				</div>
				<div class="col-6">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("nombreProd")%></output>
						<label class="col-sm-2 col-form-label">Producto</label>
				</div>
				<div class="col-2">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2">#</output>
						<label class="col-sm-2 col-form-label">cantidad</label>
				</div>
				<div class="col-2">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("venta")%></output>
						<label class="col-sm-2 col-form-label">Vlr. Total</label>
				</div>
			</div>
		</form>

	</div>

<div
		class="container">
		<form method="get" action="./VentasServlet">
			<input type="hidden" name="tipo" value="buscar_prod2" />
			<div class="row">
				<div class="col-2">
					<input type="text" class="form-control" name="txtcodprod2"
						placeholder="Codigo" aria-label="Codigo"
						aria-describedby="basic-addon2">
					<!--  <div class="input-group-append">-->
					<button class="btn btn-primary" type="submit">Consultar</button>
					<!--  </div>-->
				</div>
				<div class="col-6">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("nombreProd2")%></output>
						<label class="col-sm-2 col-form-label">Producto</label>
				</div>
				<div class="col-2">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2">#</output>
						<label class="col-sm-2 col-form-label">cantidad</label>
				</div>
				<div class="col-2">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("venta2")%></output>
						<label class="col-sm-2 col-form-label">Vlr. Total</label>
				</div>
			</div>
		</form>

	</div>

<div
		class="container">
		<form method="get" action="./VentasServlet">
			<input type="hidden" name="tipo" value="buscar_prod3" />
			<div class="row">
				<div class="col-2">
					<input type="text" class="form-control" name="txtcodprod3"
						placeholder="Codigo" aria-label="Codigo"
						aria-describedby="basic-addon2">
					<!--  <div class="input-group-append">-->
					<button class="btn btn-primary" type="submit">Consultar</button>
					<!--  </div>-->
				</div>
				<div class="col-6">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("nombreProd3")%></output>
						<label class="col-sm-2 col-form-label">Producto</label>
				</div>
				<div class="col-2">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2">#</output>
						<label class="col-sm-2 col-form-label">cantidad</label>
				</div>
				<div class="col-2">
					<output class="form-control" aria-label="Cedula"
						aria-describedby="basic-addon2"><%=request.getAttribute("venta3")%></output>
						<label class="col-sm-2 col-form-label">Vlr. Total</label>
				</div>
			</div>
		</form>

	</div>


	

</body>
</html>