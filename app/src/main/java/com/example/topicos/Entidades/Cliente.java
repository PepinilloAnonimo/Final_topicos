package com.example.topicos.Entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int identificacion;
    private String nombre;
    private String direccion;
    private int idCiudad;

    public Cliente() {

    }

    public Cliente(int identificacion, String nombre, String direccion, int idCiudad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
}
