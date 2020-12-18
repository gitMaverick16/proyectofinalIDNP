package com.example.proyectoidnp.view.historial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.view.entrenamiento.dual;
import com.example.proyectoidnp.view.entrenamiento.entrenamiento;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.reproductor.reproductor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class historial extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        bottomNavigationView = findViewById(R.id.NavigationButton);
        //bottomNavigationView.setSelectedItemId(R.id.action_historial);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_musica:
                        startActivity(new Intent(getApplicationContext(), reproductor.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_entrenamiento:
                        startActivity(new Intent(getApplicationContext(), entrenamiento.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_iniciar:
                        startActivity(new Intent(getApplicationContext(), dual.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_estadistica:
                        startActivity(new Intent(getApplicationContext(), estadisticas.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_mapa:
                        return true;

                }
                return false;
            }
        });
    }
}