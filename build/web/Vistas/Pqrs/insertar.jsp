<%-- 
    Document   : insertar
    Created on : 6 jun 2023, 15:00:15
    Author     : Omaroa   omaroaing@gmail.com
--%>

<%@page import="ModelosDAO.PqrsDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelos.TipoRequerimiento"%>
<%@page import="ModelosDAO.TipoRequerimientoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/bootstrap.css">
        <link rel="stylesheet" href="Css/style.css">
        <title>Formulario Radicar PQRS</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp" %>
        <div class="container">
            <h1>Formulario para Radicar PQRS</h1>
            <form action="PqrsControlador" method="POST">
                <div class="row">
                    <div class="col-md-4">
                        <label for="">Fecha:</label>
                        <input type="date" name="fecha" id="fecha" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label for="">Descripcion:</label>
                        <textarea name="descripcion" id="descripcion" class="form-control" required></textarea>
                    </div>
                    <div class="col-md-4">
                        <label for="">Tipo de Requerimiento</label>
                        <select name="requerimiento_id" id="requerimiento_id" class="form-control" required="">
                            <%
                                TipoRequerimientoDAO trDAO = new TipoRequerimientoDAO();
                                List<TipoRequerimiento>lista=trDAO.listartiporequerimiento();
                                Iterator<TipoRequerimiento>itertiporequerimiento=lista.iterator();
                                TipoRequerimiento tr = null;
                                while (itertiporequerimiento.hasNext()) {                            
                                    tr =itertiporequerimiento.next();
                            %>
                            <option value="<%=tr.getId() %>"><%=tr.getNombre()%><option/>
                            <% } %>
                        </select>
                    </div>
                </div><br><br>
                <input type="hidden" name="estado" id="estado" value="Sin Verificar" >
                <input type="hidden" name="usuarios_id" id="usuarios_id" value=1 >
                <input type="submit" value="Guardar" name="accion" class="btn btn-success alinear">
            </form>

        </div>


        <%@include file="../Menu/footer.jsp" %>
    </body>
</html>
