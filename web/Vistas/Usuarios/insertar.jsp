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
        <title>Crear nuevo Usuario</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp" %>
        <div class="container">
            <h1>Crear nuevo Usuario</h1>
            <form action="UsuarioControlador" method="POST">
                <div class="row">
                    <div class="col-md-4">
                        <label for="">Nombre Completo:</label>
                        <input type="text" name="nombrecompleto" id="nombrecompleto" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label for="">Nombre de Usuario:</label>
                        <input type="text" name="nombreusuario" id="nombreusuario" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label for="">Contraseña:</label>
                        <input type="password" name="contrasena" id="contrasena" class="form-control" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label for="">Email:</label>
                        <input type="email" name="email" id="email" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label for="">Celular:</label>
                        <input type="number" name="celular" id="celular" class="form-control" required>
                    </div>
                </div><br><br>
                <input type="submit" value="Guardar" name="accion" class="btn btn-success alinear">
            </form>

        </div>


        <%@include file="../Menu/footer.jsp" %>
    </body>
</html>
