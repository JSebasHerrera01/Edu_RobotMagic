package com.example.robotmagic;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Main_Login extends MainActivity {

    Button button_exit, button_login;
    EditText text_user, text_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);


        button_exit = (Button) findViewById(R.id.buttonExit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        text_user = (EditText)findViewById(R.id.TextUser_Login);
        text_pass = (EditText)findViewById(R.id.TextPassword_Login);
        button_login = (Button)findViewById(R.id.buttonLogin);


        button_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String textsIngress = text_user.getText().toString();
                String passInput = text_pass.getText().toString();

                // Compara con el usuario de prueba
                if (textsIngress.equals("") && passInput.equals("")) {
                    // Los datos de inicio de sesión son correctos, inicia el nuevo Activity
                    Intent intent = new Intent(Main_Login.this, Main_principal.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Main_Login.this, "Usuario o contraseña incorrectos, intenta con PRUEBA/1234 por defecto", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
