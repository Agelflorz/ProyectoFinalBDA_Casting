/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Usuario;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.ArrayList;
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
        BasicDBObject documento = new BasicDBObject();
        documento.put("Nombre", cliente.getNombreUsuario());
        documento.put("Contraseña",cliente.getPassword());
        collection.insert(documento);
    }

    @Override
    public void eliminar(Usuario usuario) {
        collection.remove(new BasicDBObject("Nombre", usuario.getNombreUsuario()));
    }

    @Override
    public List<Usuario> BuscarID(Usuario usuario) {
        BasicDBObject documento = (BasicDBObject) collection.findOne(new BasicDBObject("Nombre", usuario));
        if (documento!=null) {
            List<Usuario> lista = new ArrayList<>();
            lista.add(new Usuario(documento.getString("Nombre"), documento.getString("Password")));
            return lista;
        }else{
            return null;
        }
        
    }

    @Override
    public List<Usuario> MostrarTodas() {
        List<Usuario> lista = new ArrayList<>();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {            
            DBObject obj = cursor.next();
            lista.add(new Usuario((String) obj.get("Nombre"), (String) obj.get("Password")));
           
        }
        return lista;
    }

    @Override
    public void actualizar(Usuario UsuarioActualizado) {
        DBObject buscar = (DBObject) collection.findOne(new BasicDBObject("Nombre", UsuarioActualizado.getNombreUsuario()));
        if (buscar!=null) {
            BasicDBObject valorCambiar = new BasicDBObject("Nombre", UsuarioActualizado.getNombreUsuario());
            BasicDBObject valorCambiar2 = new BasicDBObject("Contraseña", UsuarioActualizado.getPassword());
            BasicDBObject actualizaOperacion = new BasicDBObject("$set", valorCambiar);
            BasicDBObject actualizaOperacion2 = new BasicDBObject("$set", valorCambiar2);            
            collection.update(buscar, actualizaOperacion);
            collection.update(buscar, actualizaOperacion2);            
        }
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
