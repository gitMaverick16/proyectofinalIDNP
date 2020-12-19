package com.example.proyectoidnp.view.historial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectoidnp.LoginView;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.pojo.UbicacionPojo;
import com.example.proyectoidnp.view.entrenamiento.dual;
import com.example.proyectoidnp.view.entrenamiento.entrenamiento;
import com.example.proyectoidnp.view.estadisticas.estadisticas;
import com.example.proyectoidnp.view.reproductor.reproductor;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class historial extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView lista;
    private List<UbicacionPojo> listaHistorial = new ArrayList<UbicacionPojo>();
    ArrayAdapter<UbicacionPojo> adapterHistorial;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        lista = (ListView)findViewById(R.id.listaDatosHistorial);

        inicioFireBase();
        listaDatos();

        bottomNavigationView = findViewById(R.id.NavigationButton);
        //bottomNavigationView.setSelectedItemId(R.id.action_historial);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_musica:
                        startActivity(new Intent(getApplicationContext(), reproductor.class));
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
                    case R.id.action_estadistica:
                        startActivity(new Intent(getApplicationContext(), estadisticas.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_mapa:
                        return true;

                }
                return false;
            }
        });

    }
    private void listaDatos(){
        databaseReference.child("Ubicacion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaHistorial.clear();
                for(DataSnapshot objSnaptshot : snapshot.getChildren()){
                    UbicacionPojo e = objSnaptshot.getValue(UbicacionPojo.class);
                    listaHistorial.add(e);

                    adapterHistorial = new ArrayAdapter<UbicacionPojo>(historial.this, android.R.layout.simple_list_item_1,listaHistorial);
                    lista.setAdapter(adapterHistorial);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void inicioFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
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
}