/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Fases;
import java.util.List;

/**
 *
 * @author blude
 */
public interface IFases {
    public void agregar(Fases Fase);
    
    public void eliminar(int id);

    public List<Fases> BuscarID(int id);

    List<Fases> MostrarTodas();

    public void actualizar(Fases FasesActualizado);
    
    public void crearConexion();
}
