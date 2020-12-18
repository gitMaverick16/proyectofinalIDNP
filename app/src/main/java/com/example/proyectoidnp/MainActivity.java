package com.example.proyectoidnp;
import com.example.proyectoidnp.view.entrenamiento.dual;
import com.example.proyectoidnp.view.entrenamiento.entrenamiento;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.perfil.perfil;
import com.example.proyectoidnp.view.reproductor.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView mBottonNavegation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.NavigationButton);
        bottomNavigationView.setSelectedItemId(R.id.action_musica);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_estadistica:
                    case R.id.action_mapa:
                        startActivity(new Intent(getApplicationContext(), dual.class));
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
                    case R.id.action_musica:
                        return true;
                }
                return false;
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
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.barPerfil:
                Toast.makeText(getApplicationContext(), "ver Perfil", Toast.LENGTH_LONG).show();
            case R.id.barCerrarSesion:
                Toast.makeText(getApplicationContext(), "Cerrar Sesion", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}