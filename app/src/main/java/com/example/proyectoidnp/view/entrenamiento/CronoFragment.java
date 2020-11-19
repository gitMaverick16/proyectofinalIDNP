package com.example.proyectoidnp.view.entrenamiento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.proyectoidnp.R;

public class CronoFragment extends Fragment {

    protected Button terminar, parar;
    protected Chronometer crono;
    protected boolean corriendo=true;
    private Long chronStateSave = 0L;
    public CronoFragment() {
        // Required empty public constructor
    }
    public static CronoFragment newInstance(String param1, String param2) {
        CronoFragment fragment = new CronoFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View main=inflater.inflate(R.layout.fragment_crono, container, false);
        terminar = (Button) main.findViewById(R.id.terminar);
        parar = (Button) main.findViewById(R.id.pausar);
        crono = (Chronometer) main.findViewById(R.id.cronometro);
        crono.setBase(SystemClock.elapsedRealtime());
        crono.start();
        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(corriendo){
                    chronStateSave = SystemClock.elapsedRealtime();
                    crono.stop();
                    parar.setText("Reanudar");
                    corriendo=false;
                }else{
                    long intervalOnPause = (SystemClock.elapsedRealtime() - chronStateSave);
                    crono.setBase( crono.getBase() + intervalOnPause );
                    crono.start();
                    corriendo=true;
                    parar.setText("Parar");
                }
            }
        });

        return main;
    }

}