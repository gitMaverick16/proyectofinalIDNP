package com.example.proyectoidnp.interfaces.viewinterface;

import com.example.proyectoidnp.model.usuarios.User;

public interface LoginInterfaceView {
    void showProgress();
    void hideProgress();
    void checkSession(String request, boolean exito);
    void showErrorUser();
    void showErrorPassword();

    void navigateToRegister();
    void navigateToLogin();
}
