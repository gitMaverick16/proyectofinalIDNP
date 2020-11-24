package com.example.proyectoidnp.interfaces.presentadorInterface;

import com.example.proyectoidnp.model.usuarios.User;

public interface LoginInterfacePresenter {
    void validateUser(String username, String password);
    void usernameError();
    void passwordError();
    void exitoOperacion();
}
