/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Pqrs;
import java.util.List;

/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public interface PqrsCRUD {
    public List listarpqrs();
    public boolean agregar(Pqrs pq);
    public boolean borrar(int id);
}
