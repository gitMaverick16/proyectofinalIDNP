package com.example.proyectoidnp.view.reproductor;
import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.model.reproductor.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proyectoidnp.R;
import com.example.proyectoidnp.ConjuntoEntrenamiento;
import com.example.proyectoidnp.view.entrenamiento.dual;
import com.example.proyectoidnp.view.entrenamiento.entrenamiento;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class reproductor extends AppCompatActivity {
    RecyclerView recyclerView;
    Adaptador adaptador;
    ArrayList<reproductorModelo> lista;
    BottomNavigationView bottomNavigationView;
    MediaPlayer vectormp[] = new MediaPlayer[5];
    int posicion = -1;
    Button playPlause;
    ImageButton imagenPresentada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        lista = new ArrayList<reproductorModelo>();
        agregar();
        agregarMusicas();
        recyclerView=findViewById(R.id.listaDatos);
        adaptador=new Adaptador(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
        playPlause = (Button)findViewById(R.id.botonPlay);
        playPlause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPause(view);
            }
        });
        imagenPresentada = (ImageButton) findViewById(R.id.imageButton);

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
                    case R.id.action_entrenamiento:
                        startActivity(new Intent(getApplicationContext(), entrenamiento.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_iniciar:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_mapa:
                        startActivity(new Intent(getApplicationContext(), dual.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_musica:
                        return true;
                }
                return false;
            }
        });

        //Seleccion en recyclerView
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detenerMusicas();
                reproductorModelo datoSelec = lista.get(recyclerView.getChildAdapterPosition(view));
                reiniciarReproductor();
                cambioMusica(datoSelec);
                posicion = datoSelec.getCancion();
                Toast.makeText(getApplicationContext(),datoSelec.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void agregarMusicas(){
        vectormp[0] = MediaPlayer.create(this,R.raw.chiptronical);
        vectormp[1] = MediaPlayer.create(this,R.raw.friends);
        vectormp[2] = MediaPlayer.create(this,R.raw.luchando);
        vectormp[3] = MediaPlayer.create(this,R.raw.lyonesse);
        vectormp[4] = MediaPlayer.create(this,R.raw.solvepuzzle);
    }
    public void agregar(){

        lista.add(new reproductorModelo("chiptronical",R.drawable.cancion,0));
        lista.add(new reproductorModelo("friends",R.drawable.cancion,1));
        lista.add(new reproductorModelo("luchando",R.drawable.cancion,2));
        lista.add(new reproductorModelo("lyonesse",R.drawable.cancion,3));
        lista.add(new reproductorModelo("solvepuzzle",R.drawable.cancion,4));
    }
    public void playPause(View view){
        if(posicion!=-1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].pause();
                playPlause.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24);
                Toast.makeText(getApplicationContext(),"Pausa",Toast.LENGTH_SHORT).show();
            }else{
                vectormp[posicion].start();
                playPlause.setBackgroundResource(R.drawable.ic_baseline_pause_circle_outline_24);
                Toast.makeText(getApplicationContext(),"Play",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Selecciona una Canción",Toast.LENGTH_SHORT).show();
        }
    }
    public void cambioMusica(reproductorModelo reproductor){
        imagenPresentada.setImageResource(reproductor.getFoto());
    }
    public void reiniciarReproductor(){
        playPlause.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24);
    }
    public void detenerMusicas(){
        for(int i=0;i<5;i++){
            if(vectormp[i].isPlaying())
                vectormp[i].stop();
        }
        playPlause.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24);
    }
}