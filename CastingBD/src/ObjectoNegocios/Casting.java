/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectoNegocios;

import java.util.Date;

/**
 *
 * @author blude
 */
public class Casting {
    int CodigoCasting;
    String NombreCasting;
    int costoCasting;
    int Fases;
    String DescripcionCasting;
    String FechaConstratacion;
    String NombreEmpresa;
    

    public Casting() {
    }

    public Casting(int CodigoCasting, String NombreCasting, int costoCasting, int Fases, String DescripcionCasting, String FechaConstratacion, String NombreEmpresa) {
        this.CodigoCasting = CodigoCasting;
        this.NombreCasting = NombreCasting;
        this.costoCasting = costoCasting;
        this.Fases = Fases;
        this.DescripcionCasting = DescripcionCasting;
        this.FechaConstratacion = FechaConstratacion;
        this.NombreEmpresa = NombreEmpresa;
    }

    public int getCodigoCasting() {
        return CodigoCasting;
    }

    public void setCodigoCasting(int CodigoCasting) {
        this.CodigoCasting = CodigoCasting;
    }

    public String getNombreCasting() {
        return NombreCasting;
    }

    public void setNombreCasting(String NombreCasting) {
        this.NombreCasting = NombreCasting;
    }

    public int getCostoCasting() {
        return costoCasting;
    }

    public void setCostoCasting(int costoCasting) {
        this.costoCasting = costoCasting;
    }

    public int getFases() {
        return Fases;
    }

    public void setFases(int Fases) {
        this.Fases = Fases;
    }

    public String getDescripcionCasting() {
        return DescripcionCasting;
    }

    public void setDescripcionCasting(String DescripcionCasting) {
        this.DescripcionCasting = DescripcionCasting;
    }

    public String getFechaConstratacion() {
        return FechaConstratacion;
    }

    public void setFechaConstratacion(String FechaConstratacion) {
        this.FechaConstratacion = FechaConstratacion;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    @Override
    public String toString() {
        return "Casting{" + "CodigoCasting=" + CodigoCasting + ", NombreCasting=" + NombreCasting + ", costoCasting=" + costoCasting + ", Fases=" + Fases + ", DescripcionCasting=" + DescripcionCasting + ", FechaConstratacion=" + FechaConstratacion + ", NombreEmpresa=" + NombreEmpresa + '}';
    }
}
