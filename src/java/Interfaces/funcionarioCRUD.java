/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Funcionario;
import java.util.List;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public interface funcionarioCRUD {
    
    public List listarfuncionario();
    public boolean agregar(Funcionario f);
    public Funcionario listarunfuncionario(int id);
    public boolean actualizar(Funcionario f);
    public boolean borrar(int id);
    
}
