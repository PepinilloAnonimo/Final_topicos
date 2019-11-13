package com.example.topicos.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.topicos.Entidades.Cliente;
import com.example.topicos.R;
import com.example.topicos.SQLite.ConexionSQLite;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {
    ListView lvHistorial;
    ArrayList<String> listaInfo;
    ArrayList<Cliente> listaClientes;

    ConexionSQLite conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        conn = new ConexionSQLite(getApplicationContext());

        lvHistorial = (ListView)findViewById(R.id.lvArticulos);

        consultarListaClientes();
    }

    private void consultarListaClientes() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Cliente cliente = null;
        listaClientes = new ArrayList<Cliente>();
        Cursor cursor = db.rawQuery("SELECT * FROM Factura WHERE idCliente ", null);
    }
}
