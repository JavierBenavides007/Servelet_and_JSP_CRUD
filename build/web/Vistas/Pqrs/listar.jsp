<%-- 
    Document   : listar
    Created on : 6 jun 2023, 15:00:44
    Author     : Omaroa   omaroaing@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelos.Pqrs"%>
<%@page import="ModelosDAO.PqrsDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/bootstrap.css">
        <link rel="stylesheet" href="Css/style.css">
        <title>Listado de PQRS</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp" %>
        <div class="container">
            <h1>Listado de PQRS</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Tipo de Requerimiento</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    PqrsDAO pqDAO = new PqrsDAO();
                    List<Pqrs>lista=pqDAO.listarpqrs();
                    Iterator<Pqrs>iterpqrs=lista.iterator();
                    Pqrs pq = null;
                    while (iterpqrs.hasNext()) {                            
                        pq =iterpqrs.next();
                %>
                    <tr>
                        <td><%= pq.getFecha() %></td>
                        <td><%= pq.getNombreRequerimiento()%></td>
                        <td><%= pq.getDescripcion()%></td>
                        <td><%= pq.getEstado()%></td>
                        <td><button class="btn btn-danger" onclick="borrar(<%=pq.getId()%>)">Eliminar</button></td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        </div>
                
        <script>
            function borrar(id){
                var verificar = confirm("Desea Borrar el Registro Numero: "+id);
                if (verificar){
                    location.href= "PqrsControlador?accion=borrar&id="+id;
                }
            }
            
        </script>

        <%@include file="../Menu/footer.jsp" %>
    </body>
</html>