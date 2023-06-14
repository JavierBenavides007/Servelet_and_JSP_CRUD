/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.Pqrs;
import ModelosDAO.PqrsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public class PqrsControlador extends HttpServlet {
    String listado = "Vistas/Pqrs/listar.jsp";
    String insertar = "Vistas/Pqrs/insertar.jsp";
    Pqrs pq = new Pqrs();
    PqrsDAO pqrsDAO = new PqrsDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. *
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PqrsControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PqrsControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "listado" -> acceso=listado;
            case "insertar" -> acceso=insertar;

            case "borrar"->{
                id= Integer.parseInt(request.getParameter("id"));
                pq.setId(id);
                pqrsDAO.borrar(id);
                acceso=listado;
            }
        }
        
        RequestDispatcher cargarvista = request.getRequestDispatcher(acceso);
         cargarvista.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        switch(accion){
            case "Guardar" -> {
                String fecha = request.getParameter("fecha");
                String descripcion = request.getParameter("descripcion");
                String estado = request.getParameter("estado");
                int requerimiento_id = Integer.parseInt(request.getParameter("requerimiento_id"));
                int usuarios_id = Integer.parseInt(request.getParameter("usuarios_id"));
                
                pq.setFecha(fecha);
                pq.setDescripcion(descripcion);
                pq.setEstado(estado);
                pq.setTiporequerimientos_id(requerimiento_id);
                pq.setUsuarios_id(usuarios_id);
                pqrsDAO.agregar(pq);
                response.sendRedirect("PqrsControlador?accion=listado");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
