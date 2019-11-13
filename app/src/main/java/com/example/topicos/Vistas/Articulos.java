package com.example.topicos.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.topicos.Entidades.Cliente;
import com.example.topicos.Entidades.Producto;
import com.example.topicos.R;
import com.example.topicos.SQLite.ConexionSQLite;

import java.util.ArrayList;

public class Articulos extends AppCompatActivity {
    ListView lvArticulos;
    ArrayList<String> listaInfo;
    ArrayList<Producto> listaArticulos;
    Cliente cliente = null;
    ConexionSQLite conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        conn = new ConexionSQLite(getApplicationContext());

        lvArticulos = (ListView)findViewById(R.id.lvArticulos);

        Bundle objEnviado = getIntent().getExtras();

        if(objEnviado != null){
            cliente = (Cliente) objEnviado.getSerializable("cliente");
        }

        consultarListaArticulos();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listaInfo);
        lvArticulos.setAdapter(adapter);

        lvArticulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Producto producto = new Producto();
                producto.setIdProducto(listaArticulos.get(pos).getIdProducto());
                producto.setNombre(listaArticulos.get(pos).getNombre());
                producto.setPrecioActual(listaArticulos.get(pos).getPrecioActual());
                producto.setStock(listaArticulos.get(pos).getStock());
                producto.setIdProveedor(listaArticulos.get(pos).getIdProveedor());
                producto.setIdCategoria(listaArticulos.get(pos).getIdCategoria());

                Intent intent = new Intent(getApplicationContext(), ComprarArticulo.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("producto", producto);
                bundle.putSerializable("cliente", cliente);

                intent.putExtras(bundle);
                startActivity(intent);

                /*
                String informacion = "ID Producto: " + listaArticulos.get(pos).getIdProducto() + "\n";
                informacion += "Producto: " + listaArticulos.get(pos).getNombre() + "\n";
                informacion += "Precio Actual: " + listaArticulos.get(pos).getPrecioActual() + "\n";
                informacion += "Stock: " + listaArticulos.get(pos).getStock() + "\n";
                informacion += "Proveedor: " + listaArticulos.get(pos).getIdProveedor() + "\n";
                informacion += "Categoria: " + listaArticulos.get(pos).getIdCategoria() + "\n";

                Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_LONG).show();
                */
            }
        });
    }

    private void consultarListaArticulos() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Producto producto = null;
        listaArticulos = new ArrayList<Producto>();
        Cursor cursor = db.rawQuery("SELECT * FROM Producto", null);

        while (cursor.moveToNext()){
            producto = new Producto();
            producto.setIdProducto(cursor.getInt(0));
            producto.setNombre(cursor.getString(1));
            producto.setPrecioActual(cursor.getInt(2));
            producto.setStock(cursor.getInt(3));
            producto.setIdProveedor(cursor.getInt(4));
            producto.setIdCategoria(cursor.getInt(5));

            listaArticulos.add(producto);
        }

        obtenerLista();
    }

    private void obtenerLista() {
        listaInfo = new ArrayList<String>();

        for(int i = 0; i < listaArticulos.size(); i++){
            listaInfo.add(listaArticulos.get(i).getIdProducto() + " - " +
                    listaArticulos.get(i).getNombre());
        }
    }
}
