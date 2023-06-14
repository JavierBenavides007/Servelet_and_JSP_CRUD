<%-- 
    Document   : insertar
    Created on : 6 jun 2023, 15:00:15
    Author     : Omaroa   omaroaing@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/bootstrap.css">
        <link rel="stylesheet" href="Css/style.css">
        <title>Login de Usuario</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp" %>
        <div class="container">
            <h1>Login de Usuario</h1>
            <form action="UsuarioControlador" method="POST">
                <div class="row">
                    <div class="col-md-6">
                        <label for="">Nombre de Usuario:</label>
                        <input type="text" name="nombredeusuario" id="nombredeusuario" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label for="">Contrasena:</label>
                        <input type="password" name="contrasena" id="contrasena" class="form-control" required>
                    </div>
                </div><br><br>
                <input type="hidden" name="accion"  value="login">
                <input type="submit" value="Ingresar" name="accion" class="btn btn-success alinear">
            </form>

        </div>


        <%@include file="../Menu/footer.jsp" %>
    </body>
</html>
