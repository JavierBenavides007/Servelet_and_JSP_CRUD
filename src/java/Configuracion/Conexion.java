/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;


import java.sql.*;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public class Conexion {
   
    Connection con;
    
    // metodo constructor para el inicio de la conexion
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectopqrs","root","");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
    
}
