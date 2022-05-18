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
public class PerfilCasting {
    int CodigoPerfil;
    String Estado;
    String Sexo;
    double RangoAltura;
    int Edad;
    String ColorCabello;
    String ColorOjos;
    String Especialidad;
    String NombreCliente;
    String TipoCasting;
    String Experiencia;

    public PerfilCasting() {
    }

    public PerfilCasting(int CodigoPerfil, String Estado, String Sexo, double RangoAltura, int Edad, String ColorCabello, String ColorOjos, String Especialidad, String NombreCliente,  String TipoCasting, String Experiencia) {
        this.CodigoPerfil = CodigoPerfil;
        this.Estado = Estado;
        this.Sexo = Sexo;
        this.RangoAltura = RangoAltura;
        this.Edad = Edad;
        this.ColorCabello = ColorCabello;
        this.ColorOjos = ColorOjos;
        this.Especialidad = Especialidad;
        this.NombreCliente = NombreCliente;
        this.TipoCasting = TipoCasting;
        this.Experiencia = Experiencia;
    }

    public int getCodigoPerfil() {
        return CodigoPerfil;
    }

    public void setCodigoPerfil(int CodigoPerfil) {
        this.CodigoPerfil = CodigoPerfil;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public double getRangoAltura() {
        return RangoAltura;
    }

    public void setRangoAltura(double RangoAltura) {
        this.RangoAltura = RangoAltura;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getColorCabello() {
        return ColorCabello;
    }

    public void setColorCabello(String ColorCabello) {
        this.ColorCabello = ColorCabello;
    }

    public String getColorOjos() {
        return ColorOjos;
    }

    public void setColorOjos(String ColorOjos) {
        this.ColorOjos = ColorOjos;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getTipoCasting() {
        return TipoCasting;
    }

    public void setTipoCasting(String TipoCasting) {
        this.TipoCasting = TipoCasting;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String Experiencia) {
        this.Experiencia = Experiencia;
    }

    @Override
    public String toString() {
        return "PerfilCasting{" + "CodigoPerfil=" + CodigoPerfil + ", Estado=" + Estado + ", Sexo=" + Sexo + ", RangoAltura=" + RangoAltura + ", Edad=" + Edad + ", ColorCabello=" + ColorCabello + ", ColorOjos=" + ColorOjos + ", Especialidad=" + Especialidad + ", NombreCliente=" + NombreCliente + ", TipoCasting=" + TipoCasting + ", Experiencia=" + Experiencia + '}';
    }
    
    

}
