package com.idnp.formulariopostulante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.inputUsuario);
        pass = findViewById(R.id.inputPassword);

    }

    public void login (View view){
        Intent i = new Intent(this, Menu.class);
        if(user.getText().toString().equals("admin")) {
            if (pass.getText().toString().equals("qwerty")) {
                startActivity(i);
            }else {
                Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }
}