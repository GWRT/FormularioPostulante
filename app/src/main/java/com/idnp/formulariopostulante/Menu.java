package com.idnp.formulariopostulante;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    private ArrayList<Postulante> postulantes = new ArrayList<Postulante>();
    Bundle args = new Bundle();

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == 1){
                   Intent intent = result.getData();

                   if(intent != null){
                       Postulante postulante = (Postulante) intent.getSerializableExtra("postulante");
                       postulantes.add(postulante);
                   }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void nuevoPostulante(View view){
        Intent i = new Intent(this, PostulanteRegistro.class);
        activityLauncher.launch(i);
    }

    public void infoPostulante(View view){
        Intent i = new Intent(this, PostulanteInfo.class);
        //Toast.makeText(getApplicationContext(), postulantes.toString(), Toast.LENGTH_SHORT).show();
        args.putSerializable("arraylist", (Serializable)postulantes);
        i.putExtra("bundle", args);
        startActivity(i);
    }
}