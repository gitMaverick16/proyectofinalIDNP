package com.example.proyectoidnp.interfaces.presentadorInterface;

import android.content.Context;

import com.example.proyectoidnp.model.usuarios.User;

public interface LoginInterfacePresenter {
    void validateUser(String username, String password, Context context);
    void usernameError();
    void passwordError();
    void exitoOperacion(String request, boolean exito);
}
