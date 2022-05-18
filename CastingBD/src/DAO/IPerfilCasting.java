/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.PerfilCasting;
import java.util.List;

/**
 *
 * @author blude
 */
public interface IPerfilCasting {
    
    public void agregar(PerfilCasting perfil);

    public void eliminar(int id);

    public PerfilCasting BuscarID(int id);

    List<PerfilCasting> MostrarTodas();

    public void actualizar(PerfilCasting perfilActualizado);
    
    public void crearConexion();
}
