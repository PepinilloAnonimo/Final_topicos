package com.example.topicos.Entidades;

import java.io.Serializable;

public class Producto implements Serializable {
    private int idProducto;
    private String nombre;
    private int precioActual;
    private int stock;
    private int idProveedor;
    private int idCategoria;

    public Producto() {

    }

    public Producto(String nombre, int precioActual, int stock, int idProveedor, int idCategoria) {
        this.nombre = nombre;
        this.precioActual = precioActual;
        this.stock = stock;
        this.idProveedor = idProveedor;
        this.idCategoria = idCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
