/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;
import Modelos.Usuario;
import ModelosDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public class UsuarioControlador extends HttpServlet {
    String listado = "Vistas/Usuarios/listar.jsp";
    Usuario usu = new Usuario();
    UsuarioDAO usuDAO = new UsuarioDAO();
    int id;
    
    public UsuarioControlador(){
    }

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
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioControlador at " + request.getContextPath() + "</h1>");
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
            case "insertar" -> acceso="Vistas/Usuarios/insertar.jsp";
            case "actualizar" -> {
                request.setAttribute("id", request.getParameter("id"));
                acceso="Vistas/Usuarios/actualizar.jsp";
            }
            case "borrar"->{
                id= Integer.parseInt(request.getParameter("id"));
                usu.setId(id);
                usuDAO.borrar(id);
                acceso=listado;
            }
            case "login"->acceso="Vistas/Usuarios/login.jsp";
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
                String nombrecompleto = request.getParameter("nombrecompleto");
                String nombreusuario = request.getParameter("nombreusuario");
                String contrasena = request.getParameter("contrasena");
                String email = request.getParameter("email");
                String celular = request.getParameter("celular");
                
                usu.setNombreCompleto(nombrecompleto);
                usu.setNombreUsuario(nombreusuario);
                usu.setContrasena(contrasena);
                usu.setEmail(email);
                usu.setCelular(celular);
                usuDAO.agregar(usu);
                response.sendRedirect("UsuarioControlador?accion=listado");
            }
            case "Actualizar"->{
                id= Integer.parseInt(request.getParameter("id"));
                String nombrecompleto = request.getParameter("nombrecompleto");
                String nombreusuario = request.getParameter("nombreusuario");
                String contrasena = request.getParameter("contrasena");
                String email = request.getParameter("email");
                String celular = request.getParameter("celular");
                usu.setId(id);
                usu.setNombreCompleto(nombrecompleto);
                usu.setNombreUsuario(nombreusuario);
                usu.setContrasena(contrasena);
                usu.setEmail(email);
                usu.setCelular(celular);
                usuDAO.actualizar(usu);
                response.sendRedirect("UsuarioControlador?accion=listado");
            }
            case "login" ->{
                String nombreusuario = request.getParameter("nombreusuario");
                String contrasena = request.getParameter("contrasena");
                usu.setNombreUsuario(nombreusuario);
                usu.setContrasena(contrasena);
                usuDAO.buscarusuariologin(nombreusuario);
                System.err.println("Error de consulta puto->"+usu.getNombreCompleto());
            }
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
