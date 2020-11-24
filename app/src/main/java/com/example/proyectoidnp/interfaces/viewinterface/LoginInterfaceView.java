package com.example.proyectoidnp.interfaces.viewinterface;

import com.example.proyectoidnp.model.usuarios.User;

public interface LoginInterfaceView {
    void showProgress();
    void hideProgress();

    void showErrorUser();
    void showErrorPassword();

    void navigateToRegister();
    void navigateToLogin();
}
