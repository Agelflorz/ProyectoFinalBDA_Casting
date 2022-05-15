/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectoNegocios;

import static java.util.Calendar.DATE;
import java.util.Date;

/**
 *
 * @author blude
 */
public class Fases {
    int idFases;
    String FechaFase;

    public Fases() {
    }

    public Fases(int idFases, String FechaFase) {
        this.idFases = idFases;
        this.FechaFase = FechaFase;
    }

    public Fases(int idFases) {
    this.idFases = idFases;
    }

    public int getIdFases() {
        return idFases;
    }

    public void setIdFases(int idFases) {
        this.idFases = idFases;
    }

    public String getFechaFase() {
        return FechaFase;
    }

    public void setFechaFase(String FechaFase) {
        this.FechaFase = FechaFase;
    }

    @Override
    public String toString() {
        return  ""+idFases ;
    }

}
