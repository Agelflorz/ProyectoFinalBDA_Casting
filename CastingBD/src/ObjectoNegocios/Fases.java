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
    Date FechaFase;

    public Fases() {
    }

    public Fases(int idFases, Date FechaFase) {
        this.idFases = idFases;
        this.FechaFase = FechaFase;
    }

    public int getIdFases() {
        return idFases;
    }

    public void setIdFases(int idFases) {
        this.idFases = idFases;
    }

    public Date getFechaFase() {
        return FechaFase;
    }

    public void setFechaFase(Date FechaFase) {
        this.FechaFase = FechaFase;
    }

    @Override
    public String toString() {
        return "Fases{" + "idFases=" + idFases + ", FechaFase=" + FechaFase + '}';
    }

}
