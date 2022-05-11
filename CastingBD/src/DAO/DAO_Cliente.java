/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Cliente;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author blude
 */
public class DAO_Cliente implements IClientes {
    //Clase DAO_Cliente
    DB database;
    DBCollection collection;

    @Override
    public void agregar(Cliente cliente) {
        BasicDBObject documento = new BasicDBObject();
        documento.put("Nombre Contacto", cliente.getNombreContacto());
        documento.put("Nombre Empresa", cliente.getNombreEmpresa());
        documento.put("Telefono", cliente.getTelefono());
        documento.put("Direccion", cliente.getDireccion());
        collection.insert(documento);
    }

    @Override
    public void eliminar(String nombre) {
        collection.remove(new BasicDBObject("Nombre Contacto", nombre));
    }

    @Override
    public void BuscarNombre(String nombre) {
        BasicDBObject consulta = new BasicDBObject();
        consulta.put("Nombre Contacto", nombre);
        
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {            
            System.out.println(cursor.next());
        }
        
    }

    @Override
    public void MostrarTodas() {
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {            
            System.out.println(cursor.next());
        }
    }

    @Override
    public void actualizar(Cliente ClientesActualizado) {
        Cliente c1 = new Cliente();
        BasicDBObject actualizaCliente = new BasicDBObject();
        
        actualizaCliente.append("$set", new BasicDBObject().append("Nombre Contacto", ClientesActualizado.getNombreContacto()));
        actualizaCliente.append("$set", new BasicDBObject().append("Nombre Empresa", ClientesActualizado.getNombreEmpresa()));
        actualizaCliente.append("$set", new BasicDBObject().append("Telefono", ClientesActualizado.getTelefono()));
        actualizaCliente.append("$set", new BasicDBObject().append("Direccion", ClientesActualizado.getDireccion()));
        
        BasicDBObject buscarCliente = new BasicDBObject();
        buscarCliente.append("Nombre Contacto", c1.getNombreContacto());
        
        collection.updateMulti(buscarCliente, actualizaCliente);
    }

    @Override
    public void crearConexion() {
        MongoClient mongo = null;
        
        try {
            mongo = new MongoClient("localhost",27017);
            System.out.println("Connected to the database successfully");
            database=mongo.getDB("Casting");
            collection=database.getCollection("clientes");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexion"+ex.toString());
            
        }
    }
    
}
