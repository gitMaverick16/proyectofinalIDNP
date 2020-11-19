package com.example.proyectoidnp.interfaces.modelInterface;

import com.example.proyectoidnp.model.usuarios.User;

public interface UserInterfaceModel {
    int getId();
    String getName();
    String getUsername();
    String getPassword();
    void setId(int id);
    void setUsername(String username);
    void setPassword(String password);
    void setName(String name);
    void createUser(String name, String username, String password);
    void deleteUser(User user);
    void updateUser(User user);
    void getUser(User user);
}
