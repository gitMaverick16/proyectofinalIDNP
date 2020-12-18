package com.example.proyectoidnp.model.login;


import com.example.proyectoidnp.LoginView;
import com.example.proyectoidnp.interfaces.modelInterface.LoginInterfaceModel;
import com.example.proyectoidnp.interfaces.presentadorInterface.LoginInterfacePresenter;
import com.example.proyectoidnp.model.BaseDatos.DBHelper;

import android.content.Context;
import android.os.Handler;

public class LoginModel implements LoginInterfaceModel {
    private LoginInterfacePresenter presenter;
    private DBHelper dbHelper;
    public LoginModel(LoginInterfacePresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void validateUser(final String username, final String password, Context context) {
        dbHelper = new DBHelper(context);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String request = "";
                boolean exito=false;
                if(username.equals("") || password.equals("")){
                    request = "Complete todos los campos";
                    exito=false;
                }else {
                    boolean checkUserPassword = dbHelper.checkUsernamePassword(username,password);
                    if(checkUserPassword){
                        request = "Inicio Correto";
                        exito = true;
                    }else {
                        request = "Datos incorrectos";
                        exito = false;
                    }
                }
                presenter.exitoOperacion(request, exito);
            }
        },2000);
    }
}
