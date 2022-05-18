/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DAO.ICasting;
import ObjectoNegocios.Casting;
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
import ObjectoNegocios.Agentes;

/**
 *
 * @author blude
 */
public class DAO_Casting implements ICasting{
    //Clase DAO_Casting
    DB database;
    DBCollection collection;
    
    @Override
    public void agregar(Casting CastinNew) {
        crearConexion();
        BasicDBObject documento = new BasicDBObject();
        documento.put("CodigoCasting", CastinNew.getCodigoCasting());
        documento.put("NombreCasting", CastinNew.getNombreCasting());
        documento.put("CostoCasting", CastinNew.getCostoCasting());
        documento.put("Fase", CastinNew.getFases());
        documento.put("DescripcionCasting", CastinNew.getDescripcionCasting());
        documento.put("FechaContratacion", CastinNew.getFechaConstratacion());
        documento.put("NombreEmpresa", CastinNew.getNombreEmpresa());
        documento.put("Tipo", CastinNew.getTipo());
        documento.put("NombreAgente", CastinNew.getNombreAgente());
        collection.insert(documento);
    }

    @Override
    public void eliminar(int id) {
    collection.remove(new BasicDBObject("CodigoCasting", id));
    }

    
    public List<Casting> BuscarID(int id) {
     crearConexion();
        BasicDBObject documento = (BasicDBObject) collection.findOne(new BasicDBObject("idCasting", id));
        if (documento != null) {
            List<Casting> ListaCasting = new ArrayList<>();
            ListaCasting.add(
                    new Casting(
                            (int) documento.get("Fase")));
            return ListaCasting;
        } else {
            return null;
        }
    }

    @Override
    public List<Casting> MostrarTodas() {
       List<Casting> ListaCasting = new ArrayList<>();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            ListaCasting.add(
                    new Casting(
                            (int) obj.get("CodigoCasting"),                            
                            (String) obj.get("NombreCasting"),
                            (int) obj.get("CostoCasting"),
                            (int) obj.get("Fase"),
                            (String) obj.get("DescripcionCasting"),
                            (String) obj.get("FechaContratacion"),
                            (String) obj.get("NombreEmpresa"),
                            (String) obj.get("Tipo"),
                            (String) obj.get("NombreAgente"))

            );
        }

        return ListaCasting;

    }

    @Override
    public void actualizar(Casting CastingActualizado) {
        crearConexion();
        BasicDBObject documento = new BasicDBObject("CodigoCasting", CastingActualizado.getCodigoCasting());
        BasicDBObject documentoNuevo = new BasicDBObject();

        if (documento !=null) {
        documentoNuevo.put("CodigoCasting", CastingActualizado.getCodigoCasting());
        documentoNuevo.put("NombreCasting", CastingActualizado.getNombreCasting());
        documentoNuevo.put("CostoCasting", CastingActualizado.getCostoCasting());
        documentoNuevo.put("Fase", CastingActualizado.getFases());
        documentoNuevo.put("DescripcionCasting", CastingActualizado.getDescripcionCasting());
        documentoNuevo.put("FechaContratacion", CastingActualizado.getFechaConstratacion());
        documentoNuevo.put("NombreEmpresa", CastingActualizado.getNombreEmpresa());
        documentoNuevo.put("NombreAgente", CastingActualizado.getNombreAgente());
        }
        
//        DBObject buscar = (DBObject) collection.findOne(new BasicDBObject("CodigoCasting", CastingActualizado.getCodigoCasting()));
        
//        if (buscar != null) {
//            BasicDBObject valorCambiar = new BasicDBObject("NombreCasting", CastingActualizado.getNombreCasting());
//            BasicDBObject valorCambiar2 = new BasicDBObject("CostoCasting", CastingActualizado.getCostoCasting());
//            BasicDBObject valorCambiar3 = new BasicDBObject("Fase", CastingActualizado.getFases());
//            BasicDBObject valorCambiar4 = new BasicDBObject("DescripcionCasting", CastingActualizado.getDescripcionCasting());
//            BasicDBObject valorCambiar5 = new BasicDBObject("FechaContratacion", CastingActualizado.getFechaConstratacion());
//            BasicDBObject valorCambiar6 = new BasicDBObject("NombreEmpresa", CastingActualizado.getNombreEmpresa());
//            
//            BasicDBObject actualizaOperacion = new BasicDBObject("$set", valorCambiar);
//            BasicDBObject actualizaOperacion2 = new BasicDBObject("$set", valorCambiar2);
//            BasicDBObject actualizaOperacion3 = new BasicDBObject("$set", valorCambiar3);
//            BasicDBObject actualizaOperacion4 = new BasicDBObject("$set", valorCambiar4);
//            BasicDBObject actualizaOperacion5 = new BasicDBObject("$set", valorCambiar5);
//            BasicDBObject actualizaOperacion6 = new BasicDBObject("$set", valorCambiar6);
            
            collection.findAndModify(documento, documentoNuevo);
  
//            collection.update(buscar, actualizaOperacion);
//            collection.update(buscar, actualizaOperacion2);
//            collection.update(buscar, actualizaOperacion3);
//            collection.update(buscar, actualizaOperacion4);
//            collection.update(buscar, actualizaOperacion5);
//            collection.update(buscar, actualizaOperacion6);
            
        }
    @Override
    public void crearConexion() {
      MongoClient mongo = null;

        try {
            mongo = new MongoClient("localhost", 27017);
            System.out.println("Connected to the database successfully");
            database = mongo.getDB("Casting_D");
            collection = database.getCollection("Casting");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion" + ex.toString());

        }
    }
     public void crearConexionAgente() {
      MongoClient mongo = null;

        try {
            mongo = new MongoClient("localhost", 27017);
            System.out.println("Connected to the database successfully");
            database = mongo.getDB("Casting_D");
            collection = database.getCollection("Agentes");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion" + ex.toString());

        }
    }
     public List<Agentes> BuscarAgente() {
     try {
            crearConexionAgente();
            BasicDBObject documento = (BasicDBObject) collection.findOne();
            if (documento != null) {
                List<Agentes> ListaAgente = new ArrayList<>();
                ListaAgente.add(
                        new Agentes(
                                (String) documento.getString("Nombre")));
                return ListaAgente;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
