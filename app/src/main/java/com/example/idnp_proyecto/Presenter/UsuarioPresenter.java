package com.example.idnp_proyecto.Presenter;

import com.example.idnp_proyecto.Interface.Usuario;
import com.example.idnp_proyecto.Model.UsuarioModel;

public class UsuarioPresenter implements Usuario.Presenter {
    private Usuario.View view;
    private Usuario.Model model;

    public UsuarioPresenter(Usuario.View view){
        this.view = view;
        model = new UsuarioModel(this);
    }

    @Override
    public void addFragment() {
        model.addFragment();
    }

    @Override
    public void showFragment() {

    }
}
