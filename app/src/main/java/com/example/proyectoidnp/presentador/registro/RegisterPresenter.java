package com.example.proyectoidnp.presentador.registro;

import com.example.proyectoidnp.interfaces.modelInterface.RegisterInterfaceModel;
import com.example.proyectoidnp.interfaces.presentadorInterface.RegisterInterfacePresenter;
import com.example.proyectoidnp.interfaces.viewinterface.RegisterInterfaceView;
import com.example.proyectoidnp.model.registro.RegisterModel;
import com.example.proyectoidnp.model.usuarios.User;

public class RegisterPresenter implements RegisterInterfacePresenter {
    private RegisterInterfaceView view;
    private RegisterInterfaceModel model;

    public RegisterPresenter (RegisterInterfaceView view){
        this.view = view;
        model = new RegisterModel(this);
    }

    @Override
    public void createUser(String name, String username, String password) {
        if(view!=null){
            model.createUser(name, username, password);
        }
    }

    @Override
    public void showSaveUser(boolean respuesta) {
        view.showSaveUser(respuesta);
    }

    @Override
    public void showError(String error) {

    }
}
