package com.example.proyectoidnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoidnp.presentador.registro.RegisterPresenter;
import com.example.proyectoidnp.view.registro.RegisterView;

public class LoginActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        chargerPreference();


        register = findViewById(R.id.btn_login_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterView.class);
                startActivity(intent);
            }
        });
    }
      public void chargerPreference(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        String user= preferences.getString("username", "no existe");
        String pwd = preferences.getString("password","No existe");
        checkSession(user,pwd);

    }
   /* public void savePreference(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        String usrname = username.getText().toString();
        String pwd = password.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",usrname);
        editor.putString("password",pwd);

        username.setText(usrname);
        password.setText(pwd);

        editor.commit();
    }*/
    public void checkSession(String user, String pwd){
        if(!user.equalsIgnoreCase("no existe") && !pwd.equalsIgnoreCase("no existe")){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

}