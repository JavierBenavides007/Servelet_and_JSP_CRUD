/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;

import Modelos.Funcionario;
import Interfaces.funcionarioCRUD;
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
public class FuncionarioDAO implements funcionarioCRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Funcionario fun = new Funcionario();
    
    @Override
    public List listarfuncionario(){
        ArrayList<Funcionario>listafuncionario = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario fun = new Funcionario();
                fun.setId(rs.getInt("Id"));
                fun.setNombre(rs.getString("Nombre"));
                fun.setEmail(rs.getString("Email"));
                fun.setCelular(rs.getString("Celular"));
                listafuncionario.add(fun);
 
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+ e);
        }
        return listafuncionario;
    }
    
    @Override
    public boolean agregar(Funcionario f){
        String sql = "INSERT INTO funcionario(Nombre,Email,Celular) VALUES('"+f.getNombre()+"','"+f.getEmail()+"','"+f.getCelular()+"')";
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
    public Funcionario listarunfuncionario(int id){
        String sql = "SELECT * FROM funcionario WHERE Id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                fun.setId(rs.getInt("Id"));
                fun.setNombre(rs.getString("Nombre"));
                fun.setEmail(rs.getString("Email"));
                fun.setCelular(rs.getString("Celular"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+e);
        }
        return fun;
    }
    @Override
    public boolean actualizar(Funcionario f){
        String sql = "UPDATE funcionario SET Nombre='"+f.getNombre()+"',Email='"+f.getEmail()+"',Celular='"+f.getCelular()+"' WHERE Id="+f.getId();
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
        String sql="DELETE FROM funcionario WHERE Id="+id;
    try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en conexion"+e);
        }
        return false;
    }
} 