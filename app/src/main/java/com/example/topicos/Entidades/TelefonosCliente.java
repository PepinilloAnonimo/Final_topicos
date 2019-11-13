package com.example.topicos.Entidades;

import java.io.Serializable;

public class TelefonosCliente implements Serializable {
    private int idCliente;
    private int telefono;

    public TelefonosCliente() {

    }

    public TelefonosCliente(int idCliente, int telefono) {
        this.idCliente = idCliente;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
