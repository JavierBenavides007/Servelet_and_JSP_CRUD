/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;

import Configuracion.Conexion;
import Interfaces.PqrsCRUD;
import Modelos.Pqrs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public class PqrsDAO implements PqrsCRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listarpqrs(){
        ArrayList<Pqrs>listapqrs = new ArrayList<>();
        String sql = "SELECT pq.Id,pq.Fecha,pq.Descripcion,pq.Estado,pq.tiporequerimiento_id,tiporequerimiento.nombre AS NombreTipoRequerimiento FROM pqrs AS pq INNER JOIN tiporequerimiento ON pq.tiporequerimiento_id = tiporequerimiento.Id;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pqrs pq = new Pqrs();
                pq.setId(rs.getInt("Id"));
                pq.setFecha(rs.getString("Fecha"));
                pq.setDescripcion(rs.getString("Descripcion"));
                pq.setEstado(rs.getString("Estado"));
                //pq.setUsuarios_id(Integer.parseInt(rs.getString("funcionario_id")));
                //pq.setNombreUsuario(rs.getString("NombreFuncionario"));
                pq.setTiporequerimientos_id(Integer.parseInt(rs.getString("tiporequerimiento_id")));
                pq.setNombreRequerimiento(rs.getString("NombreTipoRequerimiento"));
                listapqrs.add(pq);
 
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta SQL ->"+ e);
        }
        return  listapqrs;
    }
    
    @Override
    public boolean agregar(Pqrs pq){
        String sql = "INSERT INTO pqrs (Fecha,Descripcion,Estado,usuarios_id,tiporequerimiento_id) VALUES('"+pq.getFecha()+"','"+pq.getDescripcion()+"','"+pq.getEstado()+"','"+pq.getUsuarios_id()+"','"+pq.getTiporequerimientos_id()+"')";
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
        String sql="DELETE FROM pqrs WHERE Id="+id;
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
