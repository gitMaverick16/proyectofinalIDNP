package com.example.proyectoidnp.view.entrenamiento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.pojo.UbicacionPojo;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.historial.historial;
import com.example.proyectoidnp.view.reproductor.reproductor;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class entrenamiento extends AppCompatActivity {
    private Button iniciar;
    private FusedLocationProviderClient ubicacion;
    FirebaseDatabase database;
    DatabaseReference reubicacion;
    BottomNavigationView mBottonNavegation;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento2);

        database = FirebaseDatabase.getInstance();
        reubicacion = database.getReference("Ubicacion");


        bottomNavigationView = findViewById(R.id.NavigationButton);
        bottomNavigationView.setSelectedItemId(R.id.action_entrenamiento);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_musica:
                        startActivity(new Intent(getApplicationContext(), reproductor.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_entrenamiento:
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




        //leer datos de firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myrefla = database.getReference("latitud");
        DatabaseReference myreflo = database.getReference("longitud");
        DatabaseReference myreffe = database.getReference("sFecha");
        DatabaseReference myrefho = database.getReference("sHora");
        myrefla.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                String value = DataSnapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myreflo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                String value = DataSnapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myreffe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                String value = DataSnapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myrefho.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                String value = DataSnapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
    public void iniciarEntrenamiento(View view){
        Intent intent=new Intent(this, dual.class);
        startActivity(intent);

                dameubicacion();



    }
    public void cambioEntrenamiento(){
        Intent intent= new Intent(this, entrenamiento.class);
        startActivity(intent);
    }
    public void cambioEstadistica(){
        Intent intent= new Intent(this, estadisticas.class);
        startActivity(intent);
    }
    public void dameubicacion(){
        if(ContextCompat.checkSelfPermission(entrenamiento.this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Tenemos permiso!!", Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.requestPermissions(entrenamiento.this,new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        ubicacion = LocationServices.getFusedLocationProviderClient(entrenamiento.this);
        ubicacion.getLastLocation().addOnSuccessListener(entrenamiento.this, new OnSuccessListener<Location>() {

            @Override
            public void onSuccess(Location location) {
                if(location != null){

                    Double latitud = location.getLatitude();
                    Double longitud = location.getLongitude();
                    Date date=new Date();
                    SimpleDateFormat fechaC=new SimpleDateFormat("d,MMMM 'del' , yyyy");
                    String sFecha=fechaC.format(date);
                    SimpleDateFormat h=new SimpleDateFormat("h:mm a");
                    String sHora = h.format(date);
                    UbicacionPojo ubi= new UbicacionPojo(latitud,longitud, sFecha, sHora);
                    reubicacion.push().setValue(ubi);
                    Toast.makeText(entrenamiento.this, "Ubicacion agregada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}