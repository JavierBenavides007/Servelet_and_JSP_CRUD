/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public class Pqrs {
    int Id;
    String Fecha;
    String Descripcion;
    String Estado;
    int usuarios_id;
    String NombreUsuario;
    int tiporequerimientos_id;
    String NombreRequerimiento;

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getNombreRequerimiento() {
        return NombreRequerimiento;
    }

    public void setNombreRequerimiento(String NombreRequerimiento) {
        this.NombreRequerimiento = NombreRequerimiento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Decripcion) {
        this.Descripcion = Decripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public int getTiporequerimientos_id() {
        return tiporequerimientos_id;
    }

    public void setTiporequerimientos_id(int tiporequerimientos_id) {
        this.tiporequerimientos_id = tiporequerimientos_id;
    }
    
}
