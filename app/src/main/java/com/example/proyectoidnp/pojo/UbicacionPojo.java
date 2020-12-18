package com.example.proyectoidnp.pojo;

public class UbicacionPojo {
    Double latitud;
    Double longitud;

    public String getsHora() {
        return sHora;
    }

    public void setsHora(String sHora) {
        this.sHora = sHora;
    }

    String sHora;

    public String getsFecha() {
        return sFecha;
    }

    public void setsFecha(String sFecha) {
        this.sFecha = sFecha;
    }

    String sFecha;
    public UbicacionPojo(){

    }
    public UbicacionPojo(Double latitud, Double longitud, String sFecha, String sHora) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.sFecha = sFecha;
        this.sHora = sHora;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public String toString(){
        return "Ubicación:  "+getLatitud()+" / "+getLongitud()+"\nFecha:  "+getsFecha()
                +"\nHora:  "+getsHora();
    }
}
