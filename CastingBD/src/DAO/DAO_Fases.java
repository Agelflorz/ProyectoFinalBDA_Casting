/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Cliente;
import ObjectoNegocios.Fases;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.toedter.calendar.JCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author blude y spide
 */
public class DAO_Fases implements IFases {
    
    DB database;
    DBCollection collection;

    @Override
    public void agregar(Fases cliente) {
        BasicDBObject documento = new BasicDBObject();
        documento.put("idFases", cliente.getIdFases());
        documento.put("FechaFase", cliente.getFechaFase());
        collection.insert(documento);
    }

    @Override
    public void eliminar(int id) {
        collection.remove(new BasicDBObject("idFases", id));
    }

    @Override
    public List<Fases> BuscarID(int id) {
        BasicDBObject documento = (BasicDBObject) collection.findOne(new BasicDBObject("idFases", id));
        if (documento != null) {
            List<Fases> listaFase = new ArrayList<>();
            listaFase.add(
                    new Fases(
                            (int) documento.getInt("idFases"),
                            documento.getDate("FechaFase"))
            );
            return listaFase;
        }else{
            return null;
        }
        
    }

    @Override
    public List<Fases> MostrarTodas() {
        List<Fases> ListaCliente = new ArrayList<>();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            ListaCliente.add(
                    new Fases(
                            (int) obj.get("idFases"),
                            (Date)obj.get("FechaFase"))
            );
        }

        return ListaCliente;
    }

    @Override
    public void actualizar(Fases FasesActualizado) {
        Fases f1 = new Fases();
        BasicDBObject actualizaFecha = new BasicDBObject();
        
        actualizaFecha.append("$set", new BasicDBObject().append("idFases", FasesActualizado.getIdFases()));
        actualizaFecha.append("$set", new BasicDBObject().append("idFases", FasesActualizado.getFechaFase()));
        BasicDBObject buscarFases = new BasicDBObject();
        buscarFases.append("idFases", f1.getIdFases());
        collection.updateMulti(buscarFases, actualizaFecha);
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
