package com.example.proyectoidnp.view.entrenamiento;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.historial.historial;
import com.example.proyectoidnp.view.reproductor.reproductor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class entrenamiento extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);
        bottomNavigationView = findViewById(R.id.NavigationButton);
        bottomNavigationView.setSelectedItemId(R.id.action_iniciar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_estadistica:
                        startActivity(new Intent(getApplicationContext(), estadisticas.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_historial:
                        startActivity(new Intent(getApplicationContext(), historial.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_iniciar:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_mapa:

                        return true;
                    case R.id.action_musica:
                        startActivity(new Intent(getApplicationContext(), reproductor.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

}
