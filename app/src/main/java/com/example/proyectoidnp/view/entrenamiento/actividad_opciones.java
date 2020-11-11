package com.example.proyectoidnp.view.entrenamiento;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.proyectoidnp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class actividad_opciones extends AppCompatActivity implements ComunicaMenu {

    Fragment[] misFragmentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_opciones);
        misFragmentos=new Fragment[3];
        misFragmentos[0]=new Correr();
        misFragmentos[1]=new Caminar();
        misFragmentos[2]=new Bicicleta();
        Bundle extras=getIntent().getExtras();
        menu(extras.getInt("BOTONPULSADO"));
    }

    @Override
    public void menu(int queboton) {
        FragmentManager miManejador=getFragmentManager();
        FragmentTransaction miTransaccion=miManejador.beginTransaction();
        //miTransaccion.replace(R.id.herramientas, misFragmentos[queboton]);
        miTransaccion.commit();

    }
}
//(R.id.herramientas, misFragmentos[queboton]);