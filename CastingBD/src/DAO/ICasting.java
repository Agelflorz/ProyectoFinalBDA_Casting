/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Casting;
import java.util.List;

/**
 *
 * @author blude
 */
public interface ICasting {
        public void agregar(Casting cliente);

    public void eliminar(int id);

    public Casting BuscarID(int id);

    List<Casting> MostrarTodas();

    public void actualizar(Casting CastingActualizado);
    
    public void crearConexion();
}
