package com.ear.evaluaciolab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    private AdaptadorDatos adaptadorDatos;
    private ArrayList<Estudiante> datosArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        datosArrayList = Principal.ListadoDatos;

        //Inicializando el adaptador
        adaptadorDatos = new AdaptadorDatos(this,  datosArrayList);
        ListView ltsDatos = (ListView) findViewById(R.id.ltsPersonalizada);
        ltsDatos.setAdapter(adaptadorDatos);

        adaptadorDatos.notifyDataSetChanged();
    }
}
