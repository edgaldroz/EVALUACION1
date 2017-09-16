package com.ear.evaluaciolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private Button btnNuevo;
    private Button ResultadoL;

    public static ArrayList<Estudiante> ListadoDatos;

    private int REQUEST_NUEVO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnNuevo = (Button) findViewById(R.id.btnNuevo);
        ResultadoL = (Button) findViewById(R.id.btnLista);
        ListadoDatos = new ArrayList<Estudiante>();

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se crea el INTENT con las dos ACTIVITIES
                Intent intent = new Intent(Principal.this, Datos_Estudiante.class);

                // Se pasa al método, el REQUEST para IDENTIFICAR A QUÉ ACTIVITY IRÁ
                startActivityForResult(intent, REQUEST_NUEVO);
            }
        });

        ResultadoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lista = new Intent(Principal.this, Resultados.class);
                startActivity(lista);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Si el RequestCode o la Activity que se llama, corresponde a ENCUESTA
        // Y SI el resultado es un OK, similar al DIALOGRESULT en C# con los MESSAGEBOX,
        // hará lo siguiente

        if((requestCode == REQUEST_NUEVO) && (resultCode == RESULT_OK))
        {
            // Se crea un Objeto DATOS
            Estudiante Obj = new Estudiante();

            // Se le llena, según se le ha enviado en BTNPROCESAR en ACTIVITY ENCUESTA
            Obj.Nombre = data.getStringExtra("NOMBRE");
            Obj.Codigo = data.getStringExtra("CODIGO");
            Obj.Materia = data.getStringExtra("MATERIA");
            Obj.Promedio = data.getStringExtra("PROMEDIO");

            // Por último, se AGREGA al ARRAYLIST<>
            ListadoDatos.add(Obj);

            Toast.makeText(getApplicationContext(), "Datos Guardados!!", Toast.LENGTH_SHORT).show();
        }
    }
}
