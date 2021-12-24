package com.example.idnp_proyecto.Presenter;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.idnp_proyecto.Base.BasePresenter;
import com.example.idnp_proyecto.Model.LoginModel;
import com.example.idnp_proyecto.View.LoginView;

public class LoginPresenter extends BasePresenter {
    private LoginView view;
    private LoginModel model;

    public LoginPresenter(@NonNull LoginView view, @NonNull LoginModel model) {
        this.view = view;
        this.model = model;
    }

    public LoginPresenter() {

    }

    public void validar(String  correo, String pass){

    }
}
