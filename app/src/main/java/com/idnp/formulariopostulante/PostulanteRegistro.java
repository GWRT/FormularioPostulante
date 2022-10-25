package com.idnp.formulariopostulante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class PostulanteRegistro extends AppCompatActivity {

    Postulante postulante;
    Bundle args = new Bundle();
    EditText dni, apellidos, nombres, fechaNac, colegioProcedencia, carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dni = findViewById(R.id.inputDNI);
        apellidos = findViewById(R.id.inputAp);
        nombres = findViewById(R.id.inputNombres);
        fechaNac = findViewById(R.id.inputFechaNac);
        colegioProcedencia = findViewById(R.id.inputIE);
        carrera = findViewById(R.id.inputCarrera);

    }

    public void enviar(View view){
        Intent i = new Intent(this, Menu.class);
        try {
            String dniString = dni.getText().toString();
            postulante = new Postulante(
                    Integer.parseInt(dniString),
                    apellidos.getText().toString(),
                    nombres.getText().toString(),
                    fechaNac.getText().toString(),
                    colegioProcedencia.getText().toString(),
                    carrera.getText().toString()
            );

            args.putSerializable("postulante", (Serializable) postulante);
            i.putExtra("postulante", postulante);

            startActivity(i);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error: "+e, Toast.LENGTH_SHORT).show();
        }
    }
}