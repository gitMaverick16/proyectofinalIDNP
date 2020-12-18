package com.example.proyectoidnp.view.reproductor;
import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.model.reproductor.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoidnp.R;
import com.example.proyectoidnp.view.entrenamiento.dual;
import com.example.proyectoidnp.view.entrenamiento.entrenamiento;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.historial.historial;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class reproductor extends AppCompatActivity {
    RecyclerView recyclerView;
    Adaptador adaptador;
    ArrayList<reproductorModelo> lista;
    BottomNavigationView bottomNavigationView;
    MediaPlayer vectormp[] = new MediaPlayer[5];
    int posicion = -1;
    Button playPlause;
    ImageView imagenPresentada;
    TextView nombrePresentado;
    List<AudioModel> nuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        final List<AudioModel> mlista = getAllAudioFromDevice(this);
        nuevo = mlista;
        lista = new ArrayList<reproductorModelo>();
        LinearLayoutManager linear =new LinearLayoutManager(this);

        recyclerView=findViewById(R.id.listaDatos);
        adaptador=new Adaptador(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
        DividerItemDecoration divididor = new DividerItemDecoration(this,linear.getOrientation());
        recyclerView.addItemDecoration(divididor);
        playPlause = (Button)findViewById(R.id.botonPlay);
        playPlause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPause(view);
            }
        });
        imagenPresentada = (ImageView) findViewById(R.id.imageButton);
        nombrePresentado = (TextView) findViewById(R.id.mostrarNombreCancion);
        agregar();
        agregarMusicas();

        bottomNavigationView = findViewById(R.id.NavigationButton);
        bottomNavigationView.setSelectedItemId(R.id.action_musica);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_musica:
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
                        startActivity(new Intent(getApplicationContext(), historial.class));
                        overridePendingTransition(0,0);
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
                if(datoSelec.getCancion()<4) {
                    reiniciarReproductor();
                    cambioMusica(datoSelec);
                    posicion = datoSelec.getCancion();
                    Toast.makeText(getApplicationContext(), datoSelec.getNombre(),
                            Toast.LENGTH_SHORT).show();
                }
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
        for(int i=0 ; i<nuevo.size();i++){
            lista.add(new reproductorModelo(nuevo.get(i).getaName(),R.drawable.cancion,i+5));
        }
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
        nombrePresentado.setText(reproductor.getNombre());
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
    public List<AudioModel> getAllAudioFromDevice(final Context context) {
        final List<AudioModel> tempAudioList = new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.TITLE, MediaStore.Audio.AudioColumns.ALBUM, MediaStore.Audio.ArtistColumns.ARTIST,};
        Cursor c = context.getContentResolver().query(uri,
                projection,
                null,
                null,
                null);
        if (c != null) {
            while (c.moveToNext()) {
                AudioModel audioModel = new AudioModel();
                String path = c.getString(0);
                String name = c.getString(1);
                String album = c.getString(2);
                String artist = c.getString(3);

                audioModel.setaName(name);
                audioModel.setaAlbum(album);
                audioModel.setaArtist(artist);
                audioModel.setaPath(path);

                Log.e("Name :" + name, " Album :" + album);
                Log.e("Path :" + path, " Artist :" + artist);

                tempAudioList.add(audioModel);
            }
            c.close();
        }

        return tempAudioList;
    }

}