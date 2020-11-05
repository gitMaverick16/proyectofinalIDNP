package com.example.proyectoidnp.view.reproductor;
import com.example.proyectoidnp.model.reproductor.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proyectoidnp.R;

import java.util.ArrayList;
import java.util.List;

public class reproductor extends AppCompatActivity {
    RecyclerView recyclerView;
    Adaptador adaptador;
    List<reproductorModelo> lista;
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
    }
    public void agregar(){
        for(int i=0;i<15;i++) {
            lista.add(new reproductorModelo("cancion "+(i+1),R.drawable.cancion));
        }
    }
}