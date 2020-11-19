package com.example.proyectoidnp.view.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoidnp.LoginActivity;
import com.example.proyectoidnp.MainActivity;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.interfaces.presentadorInterface.RegisterInterfacePresenter;
import com.example.proyectoidnp.interfaces.viewinterface.RegisterInterfaceView;
import com.example.proyectoidnp.presentador.registro.RegisterPresenter;

public class RegisterView extends AppCompatActivity implements RegisterInterfaceView {
    private TextView name;
    private TextView username;
    private TextView password;


    RegisterInterfacePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        name = findViewById(R.id.register_name);
        username = findViewById(R.id.register_username);
        password = findViewById(R.id.register_password);
        Button register = findViewById(R.id.btn_register_register);
        Button cancelar = findViewById(R.id.btn_register_cancelar);
        presenter = new RegisterPresenter(this);

        register.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(), "Se apreto",Toast.LENGTH_LONG).show();
                presenter.createUser(name.getText().toString(),username.getText().toString(),password.getText().toString());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        chargerPreference();
    }

  /*  public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_register_cancelar:

                break;
            case R.id.btn_register_register:
                presenter.createUser(name.getText().toString(),username.getText().toString(),password.getText().toString());
                break;
        }
    }*/


    @Override
    public void showSaveUser(boolean respuesta) {
        if(respuesta){
            Toast.makeText(getApplicationContext(), "Se guardaron los datos",Toast.LENGTH_LONG).show();
            savePreference();
        }else{
            Toast.makeText(getApplicationContext(), "Error al guardar",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showError(String error) {

    }

    public void savePreference(){

        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        String usrname = username.getText().toString();
        String pwd = password.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",usrname);
        editor.putString("password",pwd);

        username.setText(usrname);
        password.setText(pwd);
        editor.commit();
    }

    public void chargerPreference(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        String user= preferences.getString("username", "no existe");
        String pwd = preferences.getString("password","No existe");
        username.setText(user);
        password.setText(pwd);
    }


}