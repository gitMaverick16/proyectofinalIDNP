package com.example.proyectoidnp.model.registro;

import android.content.Context;
import android.util.Log;

import com.example.proyectoidnp.interfaces.modelInterface.RegisterInterfaceModel;
import com.example.proyectoidnp.interfaces.presentadorInterface.RegisterInterfacePresenter;
import com.example.proyectoidnp.model.BaseDatos.DBHelper;
import com.example.proyectoidnp.model.usuarios.User;

public class RegisterModel implements RegisterInterfaceModel {
    private RegisterInterfacePresenter presenter;
    private User user;
    private String request;
    private boolean validation;
    private DBHelper dbHelper;

    public RegisterModel(RegisterInterfacePresenter presenter){

        this.presenter=presenter;
    }

    @Override
    public void createUser(String name, String username, String password, Context context) {
        dbHelper = new DBHelper(context);
        if(name.isEmpty() || username.isEmpty()|| password.isEmpty()){
            request = "Complete todos los campos";
            validation = false;
        }else {
            boolean checkUser = dbHelper.checkUsername(username);

            if (!checkUser){
                boolean insert = dbHelper.insertData(username,name,password);
                if (insert){
                    request = "Registrado Satisfactoriamente";
                    validation = true;
                }
                else {
                    request = "Fallo al registrar";
                    validation = false;
                }
            }
            else {
                request = "Usuario ya existente";
                validation = false;
            }

        }
        presenter.showSaveUser(request, validation);
    }
}
