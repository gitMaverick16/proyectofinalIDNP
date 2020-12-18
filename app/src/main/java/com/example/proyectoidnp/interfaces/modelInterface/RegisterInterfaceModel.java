package com.example.proyectoidnp.interfaces.modelInterface;

import android.content.Context;

import com.example.proyectoidnp.model.usuarios.User;

public interface RegisterInterfaceModel {

    void createUser(String name, String username, String password, Context context);
}
