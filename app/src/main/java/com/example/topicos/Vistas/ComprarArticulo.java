package com.example.topicos.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.topicos.Entidades.Cliente;
import com.example.topicos.Entidades.Producto;
import com.example.topicos.R;
import com.example.topicos.SQLite.ConexionSQLite;

import java.util.Date;


public class ComprarArticulo extends AppCompatActivity {
    TextView txtIDProducto, txtProducto, txtPrecioActual;
    Producto producto = null;
    Cliente cliente = null;
    ConexionSQLite conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_articulo);

        txtIDProducto = (TextView) findViewById(R.id.txtIDProducto);
        txtProducto = (TextView) findViewById(R.id.txtProducto);
        txtPrecioActual = (TextView) findViewById(R.id.txtPrecioActual);

        Bundle objEnviado = getIntent().getExtras();

        if(objEnviado != null){
            producto = (Producto) objEnviado.getSerializable("producto");
            cliente = (Cliente) objEnviado.getSerializable("cliente");

            txtIDProducto.setText(String.valueOf(producto.getIdProducto()));
            txtProducto.setText(producto.getNombre());
            txtPrecioActual.setText(String.valueOf(producto.getPrecioActual()));
        }

        conn = new ConexionSQLite(getApplicationContext());
    }

    private void Comprar(View view){
        SQLiteDatabase db = conn.getWritableDatabase();
        Date d = new Date();
        String fac = "INSERT INTO Factura(noFactura, fecha, idCliente, descuento, montoFinal) values (1, " + d.getTime() + ", " + cliente.getIdentificacion() +", 0, " + producto.getPrecioActual() +")";
        db.execSQL(fac);
    }
}
