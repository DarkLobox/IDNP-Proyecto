package com.example.idnp_proyecto.Model;

import com.example.idnp_proyecto.Presenter.InicioPresenter;
import android.util.Log;

public class InicioModel {
    private static final String TAG= "InicioModel";
    private InicioPresenter presenter;

    public InicioModel(InicioPresenter presenter) {
        this.presenter = presenter;
    }

    public InicioModel() {

    }
}
