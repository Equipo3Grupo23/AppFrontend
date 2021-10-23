<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Inicio de Sesión</title>
</head>
<body>
<div class="container">  <nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
    <a class="navbar-brand" href="principal.jsp">Tienda Virtual</a>
      </nav>
      </div>
<div class="container-fluid">
<div class="row"> 
<div class="col-md-4"></div> 
<div class="col-md-4">


<form action="./authServlet" method="get">
<input type="hidden" name="accion" value="Ingresar" />
  <div class="form-group row">
      <div class="form-group">
                    <label for="usuario" class="control-label col-xs-4">Usuario:</label>
                    <input type="text" name="txtusuario" id="nombre" class="form-control" />           
		
		<label for="password" class="control-label col-xs-4">Clave:</label>                   
                    <input type="password" name="txtpassword" id="password" class="form-control" /> 
		<button type="submit" class="btn btn-primary">Iniciar sesión</button>
		</div>
         </div>  

		<div>
			<p>
				<%
					String resultado = (String)request.getAttribute("mensaje");
					String mensaje = "";
					if (resultado != null) {
						mensaje = resultado;
					}
				%>
				<%=mensaje %>
			</p>
		</div>
		
	</form>
	
	</div>  
<div class="col-md-4"></div>

</body>
</html>