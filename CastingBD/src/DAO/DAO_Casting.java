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
        BasicDBObject documento = new BasicDBObject();
        documento.put("CodigoCasting", CastinNew.getCodigoCasting());
        documento.put("NombreCasting", CastinNew.getNombreCasting());
        documento.put("CostoCasting", CastinNew.getCostoCasting());
        documento.put("Fase", CastinNew.getFases());
        documento.put("DescripcionCasting", CastinNew.getDescripcionCasting());
        documento.put("FechaContratacion", CastinNew.getFechaConstratacion());
        documento.put("NombreEmpresa", CastinNew.getNombreEmpresa());
        collection.insert(documento);
    }

    @Override
    public void eliminar(int id) {
    collection.remove(new BasicDBObject("idCliente", id));
    }

    @Override
    public List<Casting> BuscarID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                            (String) obj.get("NombreEmpresa"))

            );
        }

        return ListaCasting;

    }

    @Override
    public void actualizar(Casting CastingActualizado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
