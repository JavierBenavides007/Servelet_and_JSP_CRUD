/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public class TipoRequerimiento {
    int Id;
    String Nombre;
    String Descripcion;
    int funcionario_id;
    String NombreFuncionario;

    public String getNombreFuncionario() {
        return NombreFuncionario;
    }

    public void setNombreFuncionario(String NombreFuncionario) {
        this.NombreFuncionario = NombreFuncionario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
}
