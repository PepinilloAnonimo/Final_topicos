package com.example.topicos;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topicos.Entidades.Cliente;
import com.example.topicos.SQLite.ConexionSQLite;
import com.example.topicos.Vistas.Perfil;

public class MainActivity extends AppCompatActivity {
    private TextView txtId;

    ConexionSQLite conn;
    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            txtId = (TextView)findViewById(R.id.txtId);

            conn = new ConexionSQLite(getApplicationContext());
        }

    public void Ingresar(View view){
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor;

            String [] parametros = {txtId.getText().toString()};
            cursor = db.rawQuery("SELECT * FROM Cliente WHERE identificacion =?", parametros);
            cursor.moveToFirst();
            Cliente cliente = new Cliente();
            cliente.setIdentificacion(cursor.getInt(0));
            cliente.setNombre(cursor.getString(1));
            cliente.setDireccion(cursor.getString(2));
            cliente.setIdCiudad(cursor.getInt(3));

            //Toast.makeText(getApplicationContext(), "Cliente: " + cursor.getString(1), Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, com.example.topicos.Vistas.Perfil.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("cliente", cliente);

            intent.putExtras(bundle);
            startActivity(intent);
            cursor.close();
            Limpiar();

            //Toast.makeText(getApplicationContext(), "No existe la identificación", Toast.LENGTH_LONG).show();
            //Limpiar();


        conn.close();
    }

    public void Limpiar(){
        txtId.setText("");
    }
}
