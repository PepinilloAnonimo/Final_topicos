package com.example.topicos.Entidades;

import java.io.Serializable;

public class Factura implements Serializable {
    private int noFactura;
    private String fecha;
    private int idCliente;
    private int descuento;
    private int montoFinal;

    public Factura() {

    }

    public Factura(String fecha, int idCliente, int descuento, int montoFinal) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.descuento = descuento;
        this.montoFinal = montoFinal;
    }

    public int getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(int montoFinal) {
        this.montoFinal = montoFinal;
    }
}
