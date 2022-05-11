/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Usuario;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author blude
 */
public class DAO_Usuario implements IUsuario {
    DB database;
    DBCollection collection;
    

    @Override
    public void agregar(Usuario cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario BuscarID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> MostrarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Usuario UsuarioActualizado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearConexion() {
        MongoClient mongo = null;
        
        try {
            mongo = new MongoClient("localhost",27017);
            System.out.println("Connected to the database successfully");
            database=mongo.getDB("Casting");
            collection=database.getCollection("Usuario");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexion"+ex.toString()); 
        }
    }

    
}
