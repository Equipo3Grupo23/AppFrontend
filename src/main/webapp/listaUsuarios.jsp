<%@page import="ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Nueva Tienda</title>
</head>
<body>

<div class="container">  <nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
    <a class="navbar-brand" href="principal.jsp">Tienda Virtual</a>
      </nav>
      </div>
<header id="header" class="d-flex align-items-center  header-transparent ">

   <div class="container d-flex align-items-center justify-content-between">
    <ul class="nav nav-pills nav-fill" >  
	<li class="nav-item"> <a class="nav-link" href="principal.jsp">Menu principal</a>  </li> 
	<li class="nav-item"> <a class="nav-link" href="adminUsuarios.jsp">Usuarios</a>  </li>
	<li class="nav-item"> <a class="nav-link" href="adminClientes.jsp">Clientes</a>  </li>  
	<li class="nav-item"> <a class="nav-link" href="adminProveedores.jsp">Proveedores</a>  </li>
	<li class="nav-item"> <a class="nav-link" href="adminProductos.jsp">Productos</a>  </li>  
	 <li class="nav-item"><a class="nav-link "
					href="adminVentas.jsp">Ventas</a></li>
				<li class="nav-item"><a class="nav-link active" href="reportes.jsp">Reportes</a>
				</li>
	</ul>
</div>
	</header>  

<h4><p align="center">LISTADO DE USUARIOS</p></h4>

<div class="container">
  <div class="row">
    <div class="col-sm"></div>
    <div class="col-12">
<table class="table table-sm">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Cedula</th>
      <th scope="col">Nombre</th>
      <th scope="col">Correo Electronico</th>
      <th scope="col">Usuario</th>
      <th scope="col">Password</th>
    </tr>
  </thead>
  <tbody>
  <%
ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
for (Usuarios usuario : lista){
%>
    <tr>
      <th><%=usuario.getCedula_usuario()%></th>
      <td><%=usuario.getNombre_usuario()%></td>
      <td><%=usuario.getEmail_usuario()%></td>
      <td><%=usuario.getUsuario()%></td>
      <td><%=usuario.getPassword()%></td>
    </tr>
    
<%
}%>
  </tbody>
  
</table>

  </div>
</div>
</div>







</body>
</html>