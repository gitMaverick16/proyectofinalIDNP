package com.example.proyectoidnp.model.registro;

import android.content.SharedPreferences;

import com.example.proyectoidnp.interfaces.modelInterface.RegisterInterfaceModel;
import com.example.proyectoidnp.interfaces.presentadorInterface.RegisterInterfacePresenter;
import com.example.proyectoidnp.model.usuarios.User;

import static android.content.Context.MODE_PRIVATE;

public class RegisterModel implements RegisterInterfaceModel {
    private RegisterInterfacePresenter presenter;
    private User user;
    private boolean respuesta;

    public RegisterModel(RegisterInterfacePresenter presenter){

        this.presenter=presenter;
    }

    @Override
    public void createUser(String name, String username, String password) {
        if(name.isEmpty() || username.isEmpty()|| password.isEmpty()){
            respuesta = false;
        }else {
            user = new User(name,username,password);
            respuesta = true;
        }
        String respuestas = "USUARIO REGISTRADO EXITOSAMENTE";
        presenter.showSaveUser(respuesta);
    }
}
