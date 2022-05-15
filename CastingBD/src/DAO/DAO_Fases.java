/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.Fases;
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
 * @author blude y spide
 */
public class DAO_Fases implements IFases {

    DB database;
    DBCollection collection;

    @Override
    public void agregar(Fases Fase) {
        BasicDBObject documento = new BasicDBObject();
        documento.put("idFases", Fase.getIdFases());
        documento.put("FechaFase", Fase.getFechaFase());
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
                            documento.getString("FechaFase"))
            );
            return listaFase;
        } else {
            return null;
        }

    }

    public List<Fases> BuscarIDFase() {
        try {
            crearConexion();
            BasicDBObject documento = (BasicDBObject) collection.findOne();
            if (documento != null) {
                List<Fases> listaFase = new ArrayList<>();
                listaFase.add(
                        new Fases(
                                (int) documento.getInt("idFases")));
                return listaFase;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Fases> MostrarTodas() {
        List<Fases> ListaFase = new ArrayList<>();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            ListaFase.add(
                    new Fases(
                            (int) obj.get("idFases"),
                            (String) obj.get("FechaFase"))
            );
        }

        return ListaFase;
    }

    @Override
    public void actualizar(Fases FasesActualizado) {
        DBObject buscar = (DBObject) collection.findOne(new BasicDBObject("idFases", FasesActualizado.getIdFases()));
        if (buscar != null) {
            BasicDBObject valorCambiar = new BasicDBObject("idFases", FasesActualizado.getIdFases());
            BasicDBObject valorCambiar2 = new BasicDBObject("FechaFase", FasesActualizado.getFechaFase());
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
            mongo = new MongoClient("localhost", 27017);
            System.out.println("Connected to the database successfully");
            database = mongo.getDB("Casting_D");
            collection = database.getCollection("Fase");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion" + ex.toString());

        }
    }

}
