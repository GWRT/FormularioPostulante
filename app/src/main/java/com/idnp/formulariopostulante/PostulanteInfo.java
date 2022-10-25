package com.idnp.formulariopostulante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PostulanteInfo extends AppCompatActivity {

    private TextView labelLista;
    private EditText inputSearch;
    ArrayList<Postulante> postulantes = new ArrayList<Postulante>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_postulantes);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        postulantes = (ArrayList<Postulante>) args.getSerializable("arraylist");

    }

    public void buscar(View view){
        try {
            inputSearch = findViewById(R.id.inputSearch);
            String inputSearchString = inputSearch.getText().toString();
            int dni_ = Integer.parseInt(inputSearchString);

            buscarPostulante(dni_,postulantes);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error "+e, Toast.LENGTH_SHORT).show();
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

        if(!found) imprimir();

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

    public void imprimir(){
        labelLista = findViewById(R.id.labelLista);
        String resultado = "No se encontro un resultado";
        labelLista.setText(resultado);
    }

    public void regresar (View view){
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }
}