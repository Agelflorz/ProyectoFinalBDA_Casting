/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjectoNegocios.PerfilCasting;
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
import ObjectoNegocios.Cliente;

/**
 *
 * @author blude
 */
public class DAO_PerfilCasting implements IPerfilCasting {

    DB database;
    DBCollection collection;

    @Override
    public void agregar(PerfilCasting perfil) {
    crearConexion();
        BasicDBObject documento = new BasicDBObject();
        documento.put("CodigoPerfil", perfil.getCodigoPerfil());
        documento.put("Estado", perfil.getEstado());
        documento.put("Sexo", perfil.getSexo());
        documento.put("RangoAltura", perfil.getRangoAltura());
        documento.put("Edad", perfil.getEdad());
        documento.put("ColorCabello", perfil.getColorCabello());
        documento.put("ColorOjos", perfil.getColorOjos());
        documento.put("Especialidad", perfil.getEspecialidad());
        documento.put("NombreCliente", perfil.getNombreCliente());
        documento.put("TipoCasting", perfil.getTipoCasting());
        documento.put("Experiencia", perfil.getExperiencia());
        collection.insert(documento);


    }

    @Override
    public void eliminar(int id) {
    collection.remove(new BasicDBObject("CodigoPerfil", id));
    }
    

    @Override
    public PerfilCasting BuscarID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PerfilCasting> MostrarTodas() {
        crearConexion();
        List<PerfilCasting> ListaPerfil = new ArrayList<>();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            ListaPerfil.add(
                    new PerfilCasting(
                            (int) obj.get("CodigoPerfil"),
                            (String) obj.get("Estado"),
                            (String) obj.get("Sexo"),
                            (double) obj.get("RangoAltura"),
                            (int) obj.get("Edad"),
                            (String) obj.get("ColorCabello"),
                            (String) obj.get("ColorOjos"),
                            (String) obj.get("Especialidad"),
                            (String) obj.get("NombreCliente"),
                            (String) obj.get("TipoCasting"),
                            (String) obj.get("Experiencia")
                    )
            );
        }

        return ListaPerfil;
    }

    @Override
    public void actualizar(PerfilCasting perfilActualizado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearConexion() {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost", 27017);
            System.out.println("Connected to the database successfully");
            database = mongo.getDB("Casting_D");
            collection = database.getCollection("PerfilCasting");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion" + ex.toString());

        }

    }
}
