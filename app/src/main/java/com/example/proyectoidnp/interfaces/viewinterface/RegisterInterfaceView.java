package com.example.proyectoidnp.interfaces.viewinterface;

import com.example.proyectoidnp.model.usuarios.User;

public interface RegisterInterfaceView {
    void showSaveUser(String respuesta, boolean validacion);
    void showError(String error);
}
