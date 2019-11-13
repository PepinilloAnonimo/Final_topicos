package com.example.topicos.Entidades;

import java.io.Serializable;

public class DetalleFactura implements Serializable {
    private int idDetalleFactura;
    private int noFactura;
    private int idProducto;
    private int precioVenta;
    private int cantidad;
    private int montoFinal;

    public DetalleFactura() {

    }

    public DetalleFactura(int noFactura, int idProducto, int precioVenta, int cantidad, int montoFinal) {
        this.noFactura = noFactura;
        this.idProducto = idProducto;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.montoFinal = montoFinal;
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(int montoFinal) {
        this.montoFinal = montoFinal;
    }
}
