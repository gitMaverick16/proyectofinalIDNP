package com.example.proyectoidnp.view.reproductor;
import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.model.reproductor.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyectoidnp.R;
import com.example.proyectoidnp.view.entrenamiento.entrenamiento;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.historial.historial;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class reproductor extends AppCompatActivity {
    RecyclerView recyclerView;
    Adaptador adaptador;
    List<reproductorModelo> lista;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        lista = new ArrayList<reproductorModelo>();
        agregar();
        recyclerView=findViewById(R.id.listaDatos);
        adaptador=new Adaptador(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);

        bottomNavigationView = findViewById(R.id.NavigationButton);
        bottomNavigationView.setSelectedItemId(R.id.action_musica);
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
                        return true;
                }
                return false;
            }
        });
    }
    public void agregar(){
        for(int i=0;i<15;i++) {
            lista.add(new reproductorModelo("cancion "+(i+1),R.drawable.cancion));
        }
    }
}