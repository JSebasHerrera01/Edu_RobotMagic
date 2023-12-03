package com.example.robotmagic;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.robotmagic.ProfileFragment;
import com.example.robotmagic.databinding.PrincipalMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

    public class Main_principal extends MainActivity implements ModulesFragment.ProgressListener{
        PrincipalMainBinding binding;
        private Fragment fragmentoActual;
        private ModulesFragment modulesFragment;
        private ProfileFragment profileFragment;
        private FragmentManager fragmentManager;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = PrincipalMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Inicializa el FragmentManager
            fragmentManager = getSupportFragmentManager();
            // Inicializa los fragmentos
            modulesFragment = new ModulesFragment();
            profileFragment = new ProfileFragment();

            // Carga el fragment Modules al iniciar la actividad
            cargarFragmento(profileFragment);
            cargarFragmento(modulesFragment);


            // Configura el listener para el BottomNavigationView
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.modules:
                            cargarFragmento(modulesFragment);
                            break;
                        case R.id.profile:
                            cargarFragmento(profileFragment);
                            break;
                    }
                    return true;
                }
            });
        }

        @Override
        public void onProgressUpdated(int progress) {
            // Actualiza la barra de progreso en ProfileFragment
            profileFragment.updateProgressBar(progress);
        }


        private void cargarFragmento(Fragment nuevoFragmento) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (fragmentoActual != null) {
                transaction.hide(fragmentoActual);
            }

            if (!nuevoFragmento.isAdded()) {
                transaction.add(R.id.frame_layout, nuevoFragmento);
            } else {
                transaction.show(nuevoFragmento);
            }

            fragmentoActual = nuevoFragmento;
            transaction.commit();
        }


    }
