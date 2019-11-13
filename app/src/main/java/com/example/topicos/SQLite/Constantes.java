package com.example.topicos.SQLite;

public class Constantes {
    public static final String TABLA_CIUDAD = "Ciudad";
    public static final String TABLA_PROVEEDOR = "Proveedor";
    public static final String TABLA_CLIENTE = "Cliente";
    public static final String TABLA_TELEFONOSCLIENTE = "TelefonosCliente";
    public static final String TABLA_CATEGORIA = "Categoria";
    public static final String TABLA_PRODUCTO = "Producto";
    public static final String TABLA_FACTURA = "Factura";
    public static final String TABLA_DETALLEFACTURA = "DetalleFactura";


    public static final String CREAR_TABLA_CIUDAD = "CREATE TABLE Ciudad(" +
            "idCiudad INT IDENTITY (1,1) PRIMARY KEY NOT NULL," +
            "ciudad VARCHAR(50) NOT NULL); ";

    public static final String CREAR_TABLA_PROVEEDOR ="CREATE TABLE Proveedor(" +
            "identificacion INT PRIMARY KEY NOT NULL," +
            "nombre VARCHAR(30) NOT NULL," +
            "direccion VARCHAR(30)," +
            "idCiudad INT," +
            "telefono INT," +
            "sitioWeb VARCHAR(300)); ";

    public static final String CREAR_TABLA_CLIENTE = "CREATE TABLE Cliente(" +
            "identificacion INT PRIMARY KEY NOT NULL," +
            "nombre VARCHAR(30) NOT NULL," +
            "direccion VARCHAR(30)," +
            "idCiudad INT); ";

    public static final String CREAR_TABLA_TELEFONOSCLIENTE = "CREATE TABLE TelefonosCliente(" +
            "idCliente INT," +
            "telefono INT," +
            "CONSTRAINT idTelefono PRIMARY KEY (idCliente, telefono)); ";

    public static final String CREAR_TABLA_CATEGORIA = "CREATE TABLE Categoria(" +
            "idCategoria INT IDENTITY (1,1) PRIMARY KEY NOT NULL," +
            "nombre VARCHAR(30) NOT NULL," +
            "descripcion VARCHAR(300) NOT NULL); ";

    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE Producto(" +
            "idProducto INT IDENTITY (1,1) PRIMARY KEY NOT NULL," +
            "nombre VARCHAR(30) NOT NULL," +
            "precioActual INT," +
            "stock INT," +
            "idProveedor INT," +
            "idCategoria INT); ";

    public static final String CREAR_TABLA_FACTURA = "CREATE TABLE Factura(" +
            "noFactura INT IDENTITY (1,1) PRIMARY KEY NOT NULL," +
            "fecha DATETIME," +
            "idCliente INT," +
            "descuento INT," +
            "montoFinal INT); ";

    public static final String CREAR_TABLA_DETALLEFACTURA = "CREATE TABLE DetalleFactura(\n" +
            "idDetalleFactura INT IDENTITY (1,1) PRIMARY KEY NOT NULL," +
            "noFactura INT," +
            "idProducto INT," +
            "precioVenta INT," +
            "cantidad INT," +
            "montoTotalProducto INT); ";
}
