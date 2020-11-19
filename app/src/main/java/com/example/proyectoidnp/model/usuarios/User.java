package com.example.proyectoidnp.model.usuarios;
import com.example.proyectoidnp.interfaces.modelInterface.UserInterfaceModel;

public class User implements UserInterfaceModel {
    private int id;
    private String name;
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void createUser(String name, String username, String password) {
        //se creara el usuario
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void getUser(User user) {

    }

    public int checkUserValidity(String name, String username, String password) {
        if (name==null || username==null||password==null/*||!username.equals(getUsername())||!password.equals(getPassword())*/){
            return -1;
        }
        return 0;
    }
}
