package com.idnp.formulariopostulante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class PostulanteInfo extends AppCompatActivity {

    private TextView labelLista;
    private EditText inputSearch;
    ArrayList<Postulante> postulantes = new ArrayList<Postulante>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_postulantes);

        if(savedInstanceState != null){
            Bundle argsPI = savedInstanceState.getBundle("savedState");
            postulantes.addAll((ArrayList<Postulante>) argsPI.getSerializable("bundlePI"));
        }
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        postulantes.addAll((ArrayList<Postulante>) args.getSerializable("arraylist"));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle args = new Bundle();
        args.putSerializable("bundlePI",(Serializable) postulantes);
        outState.putBundle("savedState", args);
    }

    public void buscar(View view){
        try {
            inputSearch = findViewById(R.id.inputSearch);
            String inputSearchString = inputSearch.getText().toString();
            int dni_ = Integer.parseInt(inputSearchString);

            buscarPostulante(dni_,postulantes);
        }catch (Exception e){
            imprimir("Ingrese un numero de DNI valido");
        }
    }

    public void buscarPostulante(int dni, ArrayList<Postulante> postulantes){
        boolean found = false;

        for (int i = 0; i < postulantes.size(); i++) {
            if (postulantes.get(i).DNI == dni) {
                imprimir(postulantes.get(i));
                found = true;
            }
        }

        if(!found) imprimir("No se encontro un resultado");

    }

    public void imprimir(Postulante postulante){
        labelLista = findViewById(R.id.labelLista);

        String resultado = "";
        resultado += "DNI: " + postulante.DNI
                + "\nApellidos: " + postulante.apellidos
                + "\nNombres: " + postulante.nombre
                + "\nFecha de Nacimiento: " + postulante.fechaDeNacimiento
                + "\nColegio de Procedencia: " + postulante.colegioProcedencia
                + "\nCarrera: " + postulante.carrera;

        labelLista.setText(resultado);
    }

    public void imprimir(String message){
        labelLista = findViewById(R.id.labelLista);
        labelLista.setText(message);
    }

}