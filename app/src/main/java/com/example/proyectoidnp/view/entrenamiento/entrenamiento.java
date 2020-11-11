package com.example.proyectoidnp.view.entrenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.proyectoidnp.R;

public class entrenamiento extends AppCompatActivity implements ComunicaMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);
    }

    @Override
    public void menu(int queboton) {
        Intent in=new Intent(this, actividad_opciones.class);
        in.putExtra("BOTONPULSADO", queboton);
        startActivity(in);
    }
}