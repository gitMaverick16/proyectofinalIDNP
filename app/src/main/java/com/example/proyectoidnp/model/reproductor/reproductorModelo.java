package com.example.proyectoidnp.model.reproductor;

public class reproductorModelo {
    private String nombre;
    private int foto;
    private int cancion;

    public int getCancion() {
        return cancion;
    }

    public void setCancion(int cancion) {
        this.cancion = cancion;
    }

    public reproductorModelo(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.cancion = cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
