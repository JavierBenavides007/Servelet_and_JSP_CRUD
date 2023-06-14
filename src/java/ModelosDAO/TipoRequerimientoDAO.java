/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;

import Modelos.TipoRequerimiento;
import Interfaces.tiporequerimientoCRUD;
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
public class TipoRequerimientoDAO implements tiporequerimientoCRUD{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    TipoRequerimiento tp = new TipoRequerimiento();
    
    @Override
    public List listartiporequerimiento(){
        ArrayList<TipoRequerimiento>listatiporequerimiento = new ArrayList<>();
        String sql = "SELECT tp.Id,tp.Nombre,tp.Descripcion,tp.funcionario_id,funcionario.nombre AS NombreFuncionario FROM tiporequerimiento AS tp INNER JOIN funcionario ON tp.funcionario_id = funcionario.Id;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoRequerimiento tp = new TipoRequerimiento();
                tp.setId(rs.getInt("Id"));
                tp.setNombre(rs.getString("Nombre"));
                tp.setDescripcion(rs.getString("Descripcion"));
                tp.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                tp.setNombreFuncionario(rs.getString("NombreFuncionario"));
                listatiporequerimiento.add(tp);
 
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+ e);
        }
        return listatiporequerimiento;
    }
    
    @Override
    public boolean agregar(TipoRequerimiento tp){
        String sql = "INSERT INTO tiporequerimiento (Nombre,Descripcion,funcionario_id) VALUES('"+tp.getNombre()+"','"+tp.getDescripcion()+"','"+tp.getFuncionario_id()+"')";
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
    public TipoRequerimiento listaruntiporequerimiento(int id){
        String sql = "SELECT * FROM tiporequerimiento WHERE Id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                tp.setId(rs.getInt("Id"));
                tp.setNombre(rs.getString("Nombre"));
                tp.setDescripcion(rs.getString("Descripcion"));
                tp.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+e);
        }
        return tp;
    }
    @Override
    public boolean actualizar(TipoRequerimiento tp){
        String sql = "UPDATE tiporequerimiento SET Nombre='"+tp.getNombre()+"',Descripcion='"+tp.getDescripcion()+"',funcionario_id='"+tp.getFuncionario_id()+"' WHERE Id="+tp.getId();
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
        String sql="DELETE FROM tiporequerimiento WHERE Id="+id;
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
