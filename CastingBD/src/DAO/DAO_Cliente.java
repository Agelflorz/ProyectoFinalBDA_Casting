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
import java.util.ArrayList;
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
        documento.put("idCliente", cliente.getIdCliente());
        documento.put("NombreEmpresa", cliente.getNombreEmpresa());
        documento.put("NombreContacto", cliente.getNombreContacto());
        documento.put("Telefono", cliente.getTelefono());
        documento.put("Direccion", cliente.getDireccion());
        documento.put("Actividad", cliente.getActividadCliente());
        collection.insert(documento);
    }

    @Override
    public void eliminar(int id) {
        collection.remove(new BasicDBObject("idCliente", id));
    }

    @Override
    public List<Cliente> BuscarID(int id) {
        BasicDBObject documento = (BasicDBObject) collection.findOne(new BasicDBObject("idCliente", id));
        if (documento != null) {
            List<Cliente> ListaCliente = new ArrayList<>();
            ListaCliente.add(
                    new Cliente(
                            (int)    documento.get("idCliente"),
                            (String) documento.get("NombreEmpresa"),
                            (String) documento.get("Telefono"),
                            (String) documento.get("Direccion"),
                            (String) documento.get("NombreContacto"),
                            (String) documento.get("ActividadCliente"))
            );
            return ListaCliente;
        } else {
            return null;
        }
    }

    @Override
    public List<Cliente> MostrarTodas() {
        List<Cliente> ListaCliente = new ArrayList<>();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            ListaCliente.add(
                    new Cliente(
                            (int) obj.get("idCliente"),
                            (String) obj.get("NombreEmpresa"),
                            (String) obj.get("Telefono"),
                            (String) obj.get("Direccion"),
                            (String) obj.get("NombreContacto"),
                            (String) obj.get("ActividadCliente"))
            );
        }

        return ListaCliente;
    }

    @Override
    public void actualizar(Cliente ClientesActualizado) {
        Cliente c1 = new Cliente();
        BasicDBObject actualizaCliente = new BasicDBObject();

        actualizaCliente.append("$set", new BasicDBObject().append("NombreContacto", ClientesActualizado.getNombreContacto()));
        actualizaCliente.append("$set", new BasicDBObject().append("NombreEmpresa", ClientesActualizado.getNombreEmpresa()));
        actualizaCliente.append("$set", new BasicDBObject().append("Telefono", ClientesActualizado.getTelefono()));
        actualizaCliente.append("$set", new BasicDBObject().append("Direccion", ClientesActualizado.getDireccion()));

        BasicDBObject buscarCliente = new BasicDBObject();
        buscarCliente.append("NombreContacto", c1.getNombreContacto());

        collection.updateMulti(buscarCliente, actualizaCliente);
    }

    @Override
    public void crearConexion() {
        MongoClient mongo = null;

        try {
            mongo = new MongoClient("localhost", 27017);
            System.out.println("Connected to the database successfully");
            database = mongo.getDB("Casting_D");
            collection = database.getCollection("Cliente");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion" + ex.toString());

        }
    }

}
