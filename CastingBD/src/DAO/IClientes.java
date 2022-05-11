/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import ObjectoNegocios.Cliente;
/**
 *
 * @author blude
 */
public interface IClientes {

    public void agregar(Cliente cliente);

    public void eliminar(String nombre);

    public void BuscarNombre(String nombre);

    void MostrarTodas();

    public void actualizar(Cliente ClientesActualizado);
    
    public void crearConexion();
}
