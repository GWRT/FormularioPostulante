package com.idnp.formulariopostulante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    private ArrayList<Postulante> postulantes = new ArrayList<Postulante>();
    Bundle args = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Postulante postulante = (Postulante) getIntent().getSerializableExtra("postulante");
        postulantes.add(postulante);

    }

    public void nuevoPostulante(View view){ startActivity(new Intent(this, PostulanteRegistro.class)); }

    public void infoPostulante(View view){
        Intent i = new Intent(this, PostulanteInfo.class);
        //Toast.makeText(getApplicationContext(), postulantes.toString(), Toast.LENGTH_SHORT).show();
        args.putSerializable("arraylist", (Serializable)postulantes);
        i.putExtra("bundle", args);
        startActivity(i);
    }
}