package com.example.topicos.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.topicos.Entidades.Cliente;
import com.example.topicos.R;

public class Perfil extends AppCompatActivity {
    TextView txtID, txtNombre, txtDireccion;
    Cliente cliente = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtID = (TextView) findViewById(R.id.txtID);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDireccion = (TextView) findViewById(R.id.txtDireccion);

        Bundle objEnviado = getIntent().getExtras();


        if(objEnviado != null){
            cliente = (Cliente) objEnviado.getSerializable("cliente");

            txtID.setText(String.valueOf(cliente.getIdentificacion()));
            txtNombre.setText(cliente.getNombre());
            txtDireccion.setText(cliente.getDireccion() + " - " + cliente.getIdCiudad());
        }
    }

    public void Articulos(View view){
        Intent intent = new Intent(this, com.example.topicos.Vistas.Articulos.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("cliente", cliente);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
