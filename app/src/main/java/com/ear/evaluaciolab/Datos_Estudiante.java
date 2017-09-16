package com.ear.evaluaciolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Datos_Estudiante extends AppCompatActivity {
    private EditText txtNombre, txtCodigo, txtMateria, txtNota1, txtNota2,txtNota3;
    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos__estudiante);

        btnGuardar = (Button) findViewById(R.id.btnProcesar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCodigo = (EditText) findViewById(R.id.txtCodig);
        txtMateria = (EditText) findViewById(R.id.txtMateria);
        txtNota1 = (EditText) findViewById(R.id.txtPrimerParcial);
        txtNota2 = (EditText) findViewById(R.id.txtSegundoParcial);
        txtNota3 = (EditText) findViewById(R.id.txtTercerParcial);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double N1 = Double.parseDouble(txtNota1.getText().toString());
                double N2 = Double.parseDouble(txtNota2.getText().toString());
                double N3 = Double.parseDouble(txtNota3.getText().toString());


                if(txtNombre.getText().length()!=0 && txtCodigo.getText().length()!=0
                        && txtMateria.getText().length()!=0) {

                    double promedio = (N1+N2+N3)/3;

                    String Promedio = String.format("%.2f", promedio);

                    Intent data = getIntent();
                    data.putExtra("NOMBRE", txtNombre.getText().toString());
                    data.putExtra("CODIGO", txtCodigo.getText().toString());
                    data.putExtra("MATERIA", txtMateria.getText().toString());
                    data.putExtra("PROMEDIO", Promedio);


                    setResult(RESULT_OK, data);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Elementos Vacíos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
