package com.example.proyectoidnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoidnp.interfaces.presentadorInterface.LoginInterfacePresenter;
import com.example.proyectoidnp.interfaces.viewinterface.LoginInterfaceView;
import com.example.proyectoidnp.presentador.login.LoginPresenter;
import com.example.proyectoidnp.presentador.registro.RegisterPresenter;
import com.example.proyectoidnp.view.registro.RegisterView;
import com.example.proyectoidnp.view.reproductor.reproductor;

public class LoginView extends AppCompatActivity implements LoginInterfaceView {
    private final String ERROR_USERNAME ="Usuario Incorrecto o no existe";
    private final String ERROR_PASSWORD = "Contraseña Incorrecta";
    private TextView username;
    private TextView password;
    private ProgressBar progressBar;
    private Button register;
    private Button login;
    private LoginInterfacePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        progressBar = findViewById(R.id.login_progressBar);
        presenter = new LoginPresenter(this);

        chargerPreference();
        login = findViewById(R.id.btn_login_login);
        register = findViewById(R.id.btn_login_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToRegister();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateUser(username.getText().toString(),password.getText().toString(), getApplicationContext());
            }
        });
    }
    public void chargerPreference(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        String user= preferences.getString("username", "no existe");
        String pwd = preferences.getString("password","No existe");

        if(!user.isEmpty() && !pwd.isEmpty()){
            navigateToLogin();
        }

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
    @Override
    public void checkSession(String request, boolean exito){
        if(exito){
            Toast.makeText(getApplicationContext(), request,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), reproductor.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), request, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorUser() {
        username.setError(ERROR_USERNAME);
    }

    @Override
    public void showErrorPassword() {
        password.setError(ERROR_PASSWORD);
    }

    @Override
    public void navigateToRegister() {
        startActivity(new Intent(LoginView.this,RegisterView.class));
    }

    @Override
    public void navigateToLogin() {
        startActivity(new Intent(LoginView.this,MainActivity.class));
    }

}