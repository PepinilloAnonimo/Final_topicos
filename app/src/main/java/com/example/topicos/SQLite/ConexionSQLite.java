package com.example.topicos.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLite extends SQLiteOpenHelper {
    public ConexionSQLite(Context context) {
        super(context, "DBFinalTopicos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.CREAR_TABLA_CIUDAD);
        db.execSQL(Constantes.CREAR_TABLA_PROVEEDOR);
        db.execSQL(Constantes.CREAR_TABLA_CLIENTE);
        db.execSQL(Constantes.CREAR_TABLA_TELEFONOSCLIENTE);
        db.execSQL(Constantes.CREAR_TABLA_CATEGORIA);
        db.execSQL(Constantes.CREAR_TABLA_PRODUCTO);
        db.execSQL(Constantes.CREAR_TABLA_FACTURA);
        db.execSQL(Constantes.CREAR_TABLA_DETALLEFACTURA);

        String ciu1 = "INSERT INTO Ciudad(idCiudad, ciudad) VALUES (1, 'Medellín')";
        String ciu2 = "INSERT INTO Ciudad(idCiudad, ciudad) values (2, 'Bogotá')";
        db.execSQL(ciu1);
        db.execSQL(ciu2);

        //Proveedores
        String pe1 = "INSERT INTO Proveedor(identificacion, nombre, direccion, idCiudad, telefono, sitioWeb) " +
                "values (123, 'Emp1', 'Calle 1 # 1-1', 1, 987, 'www.emp1.com')";
        String pe2 = "INSERT INTO Proveedor(identificacion, nombre, direccion, idCiudad, telefono, sitioWeb) " +
                "values (456, 'Emp2', 'Calle 2 # 2-2', 2, 654, 'www.emp2.com')";
        db.execSQL(pe1);
        db.execSQL(pe2);

        //Clientes
        String cl1 = "INSERT INTO Cliente(identificacion, nombre, direccion, idCiudad) values (321, 'Fulano', 'Calle 3 # 3-3', 2)";
        String cl2 = "INSERT INTO Cliente(identificacion, nombre, direccion, idCiudad) values (654, 'Fulana', 'Calle 4 # 4-4', 1)";
        String cl3 = "INSERT INTO Cliente(identificacion, nombre, direccion, idCiudad) values (987, 'Fulanito', 'Calle 5 # 5-5', 1)";
        db.execSQL(cl1);
        db.execSQL(cl2);
        db.execSQL(cl3);

        String telcl1 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (321, 159)";
        String tel2cl1 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (321, 753)";
        String telcl2 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (654, 486)";
        String telcl3 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (987, 153)";
        db.execSQL(telcl1);
        db.execSQL(tel2cl1);
        db.execSQL(telcl2);
        db.execSQL(telcl3);

        //Categorías
        String cat1 = "INSERT INTO Categoria(idCategoria, nombre, descripcion) values (1, 'Balones', 'Balones de fútbol, basketball, voleibol, baseball')";
        String cat2 = "INSERT INTO Categoria(idCategoria, nombre, descripcion) values (2, 'Zapatos', 'Zapatos deportivos para fútbol, basketball, voleibol, baseball')";
        db.execSQL(cat1);
        db.execSQL(cat2);

        //Productos
        String ar1 = "INSERT INTO Producto(idProducto, nombre, precioActual, stock, idProveedor, idCategoria) values (1, 'Balón Fútbol', 50000, 90, 123, 1)";
        String ar2 = "INSERT INTO Producto(idProducto, nombre, precioActual, stock, idProveedor, idCategoria) values (2, 'Balón Basketball', 70000, 50, 123, 1)";
        String ar3 = "INSERT INTO Producto(idProducto, nombre, precioActual, stock, idProveedor, idCategoria) values (3, 'Zapatos Fútbol', 210000, 60, 456, 2)";
        db.execSQL(ar1);
        db.execSQL(ar2);
        db.execSQL(ar3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versAnt, int verNueva) {
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_CIUDAD);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_PROVEEDOR);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_TELEFONOSCLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_CATEGORIA);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_FACTURA);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_DETALLEFACTURA);
        onCreate(db);
    }

    public void InsertarDatosIniciales(){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            //Ciudades
            String ciu1 = "INSERT INTO Ciudad(ciudad) values ('Medellín')";
            String ciu2 = "INSERT INTO Ciudad(ciudad) values ('Bogotá')";
            db.execSQL(ciu1);
            db.execSQL(ciu2);

            //Proveedores
            String pe1 = "INSERT INTO Proveedor(identificacion, nombre, direccion, idCiudad, telefono, sitioWeb) " +
                    "values (123, 'Emp1', 'Calle 1 # 1-1', 1, 987, 'www.emp1.com')";
            String pe2 = "INSERT INTO Proveedor(identificacion, nombre, direccion, idCiudad, telefono, sitioWeb) " +
                    "values (456, 'Emp2', 'Calle 2 # 2-2', 2, 654, 'www.emp2.com')";
            db.execSQL(pe1);
            db.execSQL(pe2);

            //Clientes
            String cl1 = "INSERT INTO Cliente(identificacion, nombre, direccion, idCiudad) values (321, 'Fulano', 'Calle 3 # 3-3', 2)";
            String cl2 = "INSERT INTO Cliente(identificacion, nombre, direccion, idCiudad) values (654, 'Fulana', 'Calle 4 # 4-4', 1)";
            String cl3 = "INSERT INTO Cliente(identificacion, nombre, direccion, idCiudad) values (987, 'Fulanito', 'Calle 5 # 5-5', 1)";
            db.execSQL(cl1);
            db.execSQL(cl2);
            db.execSQL(cl3);

            String telcl1 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (321, 159)";
            String tel2cl1 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (321, 753)";
            String telcl2 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (654, 486)";
            String telcl3 = "INSERT INTO TelefonosCliente(idCliente, telefono) values (987, 153)";
            db.execSQL(telcl1);
            db.execSQL(tel2cl1);
            db.execSQL(telcl2);
            db.execSQL(telcl3);

            //Categorías
            String cat1 = "INSERT INTO Categoria(nombre, descripcion) values ('Balones', 'Balones de fútbol, basketball, voleibol, baseball')";
            String cat2 = "INSERT INTO Categoria(nombre, descripcion) values ('Zapatos', 'Zapatos deportivos para fútbol, basketball, voleibol, baseball')";
            db.execSQL(cat1);
            db.execSQL(cat2);

            //Productos
            String ar1 = "INSERT INTO Producto(nombre, precioActual, stock, idProveedor, idCategoria) values ('Balón Fútbol', 50000, 90, 123, 1)";
            String ar2 = "INSERT INTO Producto(nombre, precioActual, stock, idProveedor, idCategoria) values ('Balón Basketball', 70000, 50, 123, 1)";
            String ar3 = "INSERT INTO Producto(nombre, precioActual, stock, idProveedor, idCategoria) values ('Zapatos Fútbol', 210000, 60, 456, 2)";
            db.execSQL(ar1);
            db.execSQL(ar2);
            db.execSQL(ar3);
        }
        db.close();
    }
}
