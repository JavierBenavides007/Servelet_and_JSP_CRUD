/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;


import Modelos.TipoRequerimiento;
import java.util.List;
/**
 *
 * @author Omaroa omaroaing@gmail.com
 */
public interface tiporequerimientoCRUD {
        
    public List listartiporequerimiento();
    public boolean agregar(TipoRequerimiento tp);
    public TipoRequerimiento listaruntiporequerimiento(int id);
    public boolean actualizar(TipoRequerimiento tp);
    public boolean borrar(int id);
}

