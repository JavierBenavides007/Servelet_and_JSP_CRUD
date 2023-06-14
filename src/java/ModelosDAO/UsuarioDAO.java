/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;


import Modelos.Usuario;
import Interfaces.usuarioCRUD;
import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public class UsuarioDAO implements usuarioCRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usu = new Usuario();
    
    @Override
    public List listarusuario(){
        ArrayList<Usuario>listausuario = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("Id"));
                usu.setNombreCompleto(rs.getString("NombreCompleto"));
                usu.setNombreUsuario(rs.getString("NombreUsuario"));
                usu.setEmail(rs.getString("Email"));
                usu.setCelular(rs.getString("Celular"));
                listausuario.add(usu);
 
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+ e);
        }
        return listausuario;
    }
    
    @Override
    public boolean agregar(Usuario u){
        String sql = "INSERT INTO usuarios(NombreCompleto,NombreUsuario,Contrasena,Email,Celular) VALUES('"+u.getNombreCompleto()+"','"+u.getNombreUsuario()+"','"+u.getContrasena()+"','"+u.getEmail()+"','"+u.getCelular()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en conexion"+e);
        }
        return false;
    }
    
    @Override
    public Usuario listarunusuario(int id){
        String sql = "SELECT * FROM usuarios WHERE Id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usu.setId(rs.getInt("Id"));
                usu.setNombreCompleto(rs.getString("NombreCompleto"));
                usu.setNombreUsuario(rs.getString("NombreUsuario"));
                usu.setEmail(rs.getString("Email"));
                usu.setCelular(rs.getString("Celular"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+e);
        }
        return usu;
    }
    @Override
    public boolean actualizar(Usuario u){
        String sql = "UPDATE usuarios SET NombreCompleto='"+u.getNombreCompleto()+"',NombreUsuario='"+u.getNombreUsuario()+"',Contrasena='"+u.getContrasena()+"',Email='"+u.getEmail()+"',Celular='"+u.getCelular()+"' WHERE Id="+u.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en conexion"+e);
        }
        return false;
    }
    
    @Override
    public boolean borrar(int id){
        String sql="DELETE FROM usuarios WHERE Id="+id;
    try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en conexion"+e);
        }
        return false;
    }
    
    @Override
    public Usuario buscarusuariologin(String nombreusuario){
        String sql = "SELECT * FROM usuarios WHERE NombreUsuario="+nombreusuario;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usu.setId(rs.getInt("Id"));
                usu.setNombreCompleto(rs.getString("NombreCompleto"));
                usu.setNombreUsuario(rs.getString("NombreUsuario"));
                usu.setEmail(rs.getString("Email"));
                usu.setCelular(rs.getString("Celular"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+e);
        }
        return usu;
    }
}
