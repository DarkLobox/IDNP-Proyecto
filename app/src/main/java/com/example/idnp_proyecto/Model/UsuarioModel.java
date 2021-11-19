package com.example.idnp_proyecto.Model;

import com.example.idnp_proyecto.Interface.Usuario;
import com.example.idnp_proyecto.View.LoginView;

public class UsuarioModel implements Usuario.Model {
    private Usuario.Presenter presenter;

    public UsuarioModel(Usuario.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void addFragment() {
        LoginView fragment = new LoginView();

    }
}
