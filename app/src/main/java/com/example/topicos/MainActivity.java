package com.example.topicos;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            NoSQL.calificar(3, "Más o menos", "Panchito", "Plancha");
            NoSQL.lista_deseos("Mesa", "Panchito");
            NoSQL.busquedas("Silla", "Panchito");
        }

}
