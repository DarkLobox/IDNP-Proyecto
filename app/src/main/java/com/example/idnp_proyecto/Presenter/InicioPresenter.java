package com.example.idnp_proyecto.Presenter;

import androidx.annotation.NonNull;

import com.example.idnp_proyecto.Base.BasePresenter;
import com.example.idnp_proyecto.Model.InicioModel;
import com.example.idnp_proyecto.View.InicioView;

public class InicioPresenter  extends BasePresenter  {
    private InicioView view;
    private InicioModel inicioModel;

    public InicioPresenter(@NonNull InicioView view, @NonNull InicioModel inicioModel) {
        this.view = view;
        this.inicioModel = inicioModel;
    }
}
