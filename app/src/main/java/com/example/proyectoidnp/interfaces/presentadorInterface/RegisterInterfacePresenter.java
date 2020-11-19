package com.example.proyectoidnp.interfaces.presentadorInterface;

import com.example.proyectoidnp.model.usuarios.User;

public interface RegisterInterfacePresenter {
    void createUser(String name, String username, String password);
    void showSaveUser(boolean respuesta);
    void showError(String error);
}
