package com.example.proyectoidnp.interfaces.presentadorInterface;

import com.example.proyectoidnp.model.usuarios.User;

public interface UserInterfacePresenter {
    void createUser(String name, String username, String password);
    void deleteUser(User user);
    void updateUser(User user);
    void getUser(User user);
}
