package com.example.proyectoidnp.presentador.login;
import android.view.View;

import com.example.proyectoidnp.LoginView;
import com.example.proyectoidnp.interfaces.modelInterface.LoginInterfaceModel;
import com.example.proyectoidnp.interfaces.presentadorInterface.LoginInterfacePresenter;
import com.example.proyectoidnp.model.login.LoginModel;

public class LoginPresenter implements LoginInterfacePresenter {
    private LoginView view;
    private LoginInterfaceModel model;

    public LoginPresenter(LoginView view){
        this.view = view;
        model = new LoginModel(this);
    }
    @Override
    public void validateUser(String username, String password) {
        if (view!=null){
            view.showProgress();
        }
        model.validateUser(username,password);
    }

    @Override
    public void usernameError() {
        if(view!=null){
            view.hideProgress();
            view.showErrorUser();
        }
    }

    @Override
    public void passwordError() {
        if(view!=null){
            view.hideProgress();
            view.showErrorPassword();
        }
    }

    @Override
    public void exitoOperacion() {
        if(view!=null){
            view.showProgress();
            view.navigateToLogin();
        }
    }
}
