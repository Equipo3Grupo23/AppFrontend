<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Usuarios" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Nueva Tienda Virtual</title>

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
	<li class="nav-item"> <a class="nav-link " href="adminUsuarios.jsp">Usuarios</a>  </li>
	<li class="nav-item"> <a class="nav-link " href="adminClientes.jsp">Clientes</a>  </li>  
	<li class="nav-item"> <a class="nav-link " href="adminProveedores.jsp">Proveedores</a>  </li>
	<li class="nav-item"> <a class="nav-link active" href="adminProductos.jsp">Productos</a>  </li>  
	 <li class="nav-item"><a class="nav-link "
					href="adminVentas.jsp">Ventas</a></li>
				<li class="nav-item"><a class="nav-link" href="reportes.jsp">Reportes</a>
				</li>
	</ul>
</div>
	</header> 
    <%!String mensaje = "";
	int codigo_producto = 0;
	double ivacompra = 0, precio_compra, precio_venta;
	String nitproveedor_key = "";
	String nombre_producto = "";
	String estado = "";%>
	
        <div>
             
            <main id="main-doc">
                <section class="main-section" id="welcome">
                    <header>Manejo Productos</header>
                    
                    <%
				//Validacion consultar
				if (request.getParameter("codigo_producto") != null) {
					codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
					ivacompra = Double.parseDouble(request.getParameter("ivacompra"));
					nitproveedor_key = request.getParameter("nitproveedor_key");
					nombre_producto = request.getParameter("nombre_producto");
					precio_compra = Double.parseDouble(request.getParameter("precio_compra"));
					precio_venta = Double.parseDouble(request.getParameter("precio_venta"));
					estado = "disabled";
				}
				%>
				
				<%
				//Actualizar
				if (request.getParameter("men") != null) {
					codigo_producto = 0;
					ivacompra = 0;
					nitproveedor_key = "";
					nombre_producto = "";
					precio_compra = 0;
					precio_venta = 0;
					estado = "";
					mensaje = request.getParameter("men");
					out.print("<script>alert('" + mensaje + "');</script>");//Mensaje con alert js
				}
				%>

                    <form action="Productos" method="post" enctype="multipart/form-data">
                        <div>
                            <label>Archivo:</label>
                            <input class="inputs" type="text" name="nombre">
                            <input class="botones" type="file" value="Examinar" name="archivo">
                        </div>
                        <div>
                            <input class="botones" type="submit" name="cargar" value="Cargar archivo">
                        </div>
                    </form>
                    
                    <form action="Productos" method="post">
					<fieldset>
						<legend>Datos del Producto</legend>
						<div>
							<label>Codigo producto: </label><input class="inputs" type="number" name="codigo_producto" value="<%=codigo_producto%>" required <%=estado%>>
						</div>
						    <input type="hidden" name="cod_prod" value="<%=codigo_producto%>">
						<div>
							<label>Iva compra: </label><input class="inputs" type="number" name="ivacompra" value="<%=ivacompra%>" required>
						</div>
						<div>
							<label>Nit proveedor: </label><input class="inputs" type="number" name="nitproveedor_key" value="<%=nitproveedor_key%>" required>
						</div>
						<div>
							<label>Nombre producto: </label><input class="inputs" type="text" name="nombre_producto" value="<%=nombre_producto%>" required>
						</div>
						<div>
							<label>Precio compra: </label><input class="inputs" type="number" name="precio_compra" value="<%=precio_compra%>" required>
						</div>
						<div>
							<label>Precio venta: </label><input class="inputs" type="number" name="precio_venta" value="<%=precio_venta%>" required>
						</div>
						<div>
							<input class="botones" type="submit" name="actualizar" value="Actualizar">
						</div>
					</fieldset>
				</form>

				<form action="Productos" method="post">
					<fieldset>
						<legend>Consultar</legend>
						<div>
							<label>Codigo producto: </label><input class="inputs" type="number" name="producto"
								required>
						</div>
						<input class="botones" type="submit" name="consultar" value="Consultar">
					</fieldset>
				</form>
                </section>
            </main>
        </div>
    </body>

    </html>