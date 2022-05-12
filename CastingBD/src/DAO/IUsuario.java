/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Usuario;
import java.util.List;

/**
 *
 * @author blude y spide
 */
public interface IUsuario {

    public void agregar(Usuario cliente);

    public void eliminar(Usuario usuario);

    public List<Usuario> BuscarID(Usuario usuario);

    List<Usuario> MostrarTodas();

    public void actualizar(Usuario UsuarioActualizado);
    
    public void crearConexion();
}
