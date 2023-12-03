package com.example.robotmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button button_empezar;
    private static final long AUTO_HIDE_DELAY_MILLIS = 1200; // Tiempo en milisegundos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hacer que el contenido se ajuste al abrir la barra de navegación
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        // Iniciar el temporizador para ocultar la barra de navegación después de un tiempo
        startAutoHideTimer();

        setContentView(R.layout.activity_main);

        button_empezar = (Button)findViewById(R.id.button_Go);
        button_empezar.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v) {
                // Define la intención de cambiar al nuevo layout
                Intent intent = new Intent(MainActivity.this, Main_Login.class);
                startActivity(intent);
            }
        });
    }

    private void startAutoHideTimer() {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> hideNavigationBar(), AUTO_HIDE_DELAY_MILLIS);
    }

    private void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }




}