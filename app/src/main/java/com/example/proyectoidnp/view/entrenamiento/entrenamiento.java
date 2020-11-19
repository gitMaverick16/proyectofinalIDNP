package com.example.proyectoidnp.view.entrenamiento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.proyectoidnp.R;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class entrenamiento extends AppCompatActivity {
    private Button iniciar;
    BottomNavigationView mBottonNavegation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento2);
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
    public void iniciarEntrenamiento(View view){
        Intent intent=new Intent(this, ConjuntoEntrenamiento.class);
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