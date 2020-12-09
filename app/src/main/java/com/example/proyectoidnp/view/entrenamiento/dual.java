package com.example.proyectoidnp.view.entrenamiento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.proyectoidnp.ConjuntoEntrenamiento;
import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.reproductor.reproductor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dual extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual);
        bottomNavigationView = findViewById(R.id.NavigationButton);
        bottomNavigationView.setSelectedItemId(R.id.action_entrenamiento);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_musica:
                        startActivity(new Intent(getApplicationContext(), reproductor.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.action_iniciar:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_mapa:

                        return true;
                    case R.id.action_entrenamiento:
                        return true;
                }
                return false;
            }
        });
    }
    public void iniciarEntrenamiento(View view){
        Intent intent=new Intent(this, dual.class);
        startActivity(intent);
    }
    public void cambioEntrenamiento(){
        Intent intent= new Intent(this, entrenamiento.class);
        startActivity(intent);
    }
    public void cambioEstadistica(){
        Intent intent= new Intent(this, estadisticas.class);
        startActivity(intent);
    }
}