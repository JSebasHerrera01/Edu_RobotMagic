package com.example.robotmagic;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Objects;


public class ProfileFragment extends Fragment {
     Button atras;
    int progress = 0;
     ProgressBar progres_general;
     TextView txt_percent_general, textView3;
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        atras = view.findViewById(R.id.exit);
        progres_general = view.findViewById(R.id.prog_colors);
        txt_percent_general = view.findViewById(R.id.txt_percent_general);

        // Asigna el valor inicial a textView3
        txt_percent_general.setText(progress + "%");

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoConfirmacion();
            }
        });

        return view;
    }

    private void mostrarDialogoConfirmacion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Cerrar Sesión");
        builder.setMessage("¿Estás seguro de que deseas cerrar sesión y salir?");
        builder.setPositiveButton("Sí", (dialog, which) -> {
            // Iniciar la actividad LoginActivity
            Intent intent = new Intent(requireContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);  // Limpia la pila de actividades
            startActivity(intent);
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.show();
    }

    public void updateProgressBar(int progress) {
        this.progress = progress;
        progres_general.setProgress(progress);
        // Actualiza el TextView en el método
        txt_percent_general.setText(String.valueOf(progress));

    }

}