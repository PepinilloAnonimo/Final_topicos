package com.example.topicos.Entidades;

import java.io.Serializable;

public class Proveedor implements Serializable {
    private int identificacion;
    private String nombre;
    private String direccion;
    private int idCiudad;
    private int telefono;
    private String sitioWeb;

    public Proveedor() {

    }

    public Proveedor(int identificacion, String nombre, String direccion, int idCiudad, int telefono, String sitioWeb) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
        this.telefono = telefono;
        this.sitioWeb = sitioWeb;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
}
