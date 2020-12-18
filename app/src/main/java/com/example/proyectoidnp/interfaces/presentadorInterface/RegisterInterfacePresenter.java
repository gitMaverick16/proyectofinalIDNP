package com.example.proyectoidnp.interfaces.presentadorInterface;

import android.content.Context;
import android.view.View;

import com.example.proyectoidnp.model.usuarios.User;

public interface RegisterInterfacePresenter {
    void createUser(String name, String username, String password, Context context);
    void showSaveUser(String request,boolean validation);
    void showError(String error);
}
