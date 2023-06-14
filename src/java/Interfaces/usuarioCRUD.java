/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Usuario;
import java.util.List;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public interface usuarioCRUD {
    
    public List listarusuario();
    public boolean agregar(Usuario u);
    public Usuario listarunusuario(int id);
    public boolean actualizar(Usuario u);
    public boolean borrar(int id);
    public Usuario buscarusuariologin(String nombreusuario);
}
