/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectoNegocios;

/**
 *
 * @author blude
 */
public class Agentes {
    int IDempleado;
    String RFC;
    String Nombre;
    String Direccion;    

    public Agentes(int IDempleado, String RFC, String Nombre, String Direccion) {
        this.IDempleado = IDempleado;
        this.RFC = RFC;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
    }

    public Agentes() {
    }

    public Agentes(String Nombre) {
    this.Nombre = Nombre;
    
    }

    public int getIDempleado() {
        return IDempleado;
    }

    public void setIDempleado(int IDempleado) {
        this.IDempleado = IDempleado;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return   ""+Nombre ;
    }
    
    
}
