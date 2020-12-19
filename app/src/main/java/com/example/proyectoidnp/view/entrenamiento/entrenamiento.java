package com.example.proyectoidnp.view.entrenamiento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectoidnp.LoginView;
import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.pojo.UbicacionPojo;
import com.example.proyectoidnp.view.entrenamiento.Entidades.Entrenamiento;
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
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
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

        //a

        //a
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
        if(ContextCompat.checkSelfPermission(
                getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    entrenamiento.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_LOCATION_PERMISSION
            );
        }else {
            startLocationService();
        }
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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.barPerfil:
                Toast.makeText(getApplicationContext(), "ver Perfil", Toast.LENGTH_LONG).show();
            case R.id.barCerrarSesion:
                deletePreference();
                Toast.makeText(getApplicationContext(), "Cerrar Sesion", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), LoginView.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deletePreference(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username","nohaynadadenada");
        editor.putString("password","nohaynadadenada");
        editor.commit();
    }
    //conseguir ubicacion cada 2 segundos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startLocationService();
            }else{
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isLocationServiceRunning(){
        ActivityManager activityManager =
                (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if(activityManager != null){
            for(ActivityManager.RunningServiceInfo service :
                    activityManager.getRunningServices(Integer.MAX_VALUE)){
                if(LocationService.class.getName().equals(service.service.getClassName())){
                    if(service.foreground){
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private void startLocationService(){
        if(!isLocationServiceRunning()){
            Intent intent =new Intent(getApplicationContext(), LocationService.class);
            intent.setAction(Constants.ACTION_START_LOCATION_SERVICE);
            startService(intent);
            Toast.makeText(this, "Location Service started", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopLocationService() {
        if(isLocationServiceRunning()){
            Intent intent = new Intent(getApplicationContext(), LocationService.class);
            intent.setAction(Constants.ACTION_STOP_LOCATION_SERVICE);
            startService(intent);
            Toast.makeText(this, "Location service stopped", Toast.LENGTH_SHORT).show();
        }
    }
}