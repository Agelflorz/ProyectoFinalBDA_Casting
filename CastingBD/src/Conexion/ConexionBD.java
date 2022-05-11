/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import javax.swing.JOptionPane;

/**
 *
 * @author blude
 */
public class ConexionBD implements IConexionBD{
    DB database;
    DBCollection collection;

    @Override
    public void crearConexion() {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost",27017);
            System.out.println("Connected to the database successfully");
            database=mongo.getDB("Restaurantes");
//            collection=database.getCollection("restaurantes");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexion"+ex.toString());
            
        }
    }
    
    
}
