package com.example.proyectoidnp;
import com.example.proyectoidnp.view.entrenamiento.entrenamiento;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.reproductor.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView mBottonNavegation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottonNavegation=(BottomNavigationView) findViewById(R.id.botnav);
        mBottonNavegation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.action_entrenamiento){
                    cambioEntrenamiento();
                }
                else if(menuItem.getItemId()==R.id.action_estadistica){
                    cambioEstadistica();
                }
                return true;
            }
        });
    }
    public void on(View v){
        Intent intent= new Intent(this, reproductor.class);
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