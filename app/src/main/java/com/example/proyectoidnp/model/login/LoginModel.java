package com.example.proyectoidnp.model.login;


import com.example.proyectoidnp.LoginView;
import com.example.proyectoidnp.interfaces.modelInterface.LoginInterfaceModel;
import com.example.proyectoidnp.interfaces.presentadorInterface.LoginInterfacePresenter;

import android.os.Handler;

public class LoginModel implements LoginInterfaceModel {
    private LoginInterfacePresenter presenter;
    public LoginModel(LoginInterfacePresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void validateUser(final String username, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!username.equals("") && !password.equals("")){
                    presenter.exitoOperacion();
                }else {
                    if(username.equals("")){
                        presenter.usernameError();
                    }
                    if (password.equals("")){
                        presenter.passwordError();
                    }
                }
            }
        },2000);
    }
}
