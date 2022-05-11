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
public class Cliente {
    double idCliente;
    String NombreEmpresa;
    double Telefono;
    String Direccion;
    String NombreContacto;
    String ActividadCliente;

    public Cliente() {
    }

    public Cliente(double idCliente, String NombreEmpresa, double Telefono, String Direccion, String NombreContacto, String ActividadCliente) {
        this.idCliente = idCliente;
        this.NombreEmpresa = NombreEmpresa;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.NombreContacto = NombreContacto;
        this.ActividadCliente = ActividadCliente;
    }

    public double getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(double idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    public double getTelefono() {
        return Telefono;
    }

    public void setTelefono(double Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNombreContacto() {
        return NombreContacto;
    }

    public void setNombreContacto(String NombreContacto) {
        this.NombreContacto = NombreContacto;
    }

    public String getActividadCliente() {
        return ActividadCliente;
    }

    public void setActividadCliente(String ActividadCliente) {
        this.ActividadCliente = ActividadCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", NombreEmpresa=" + NombreEmpresa + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", NombreContacto=" + NombreContacto + ", ActividadCliente=" + ActividadCliente + '}';
    }
    
}
