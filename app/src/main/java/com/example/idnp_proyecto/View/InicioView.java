package com.example.idnp_proyecto.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.example.idnp_proyecto.Base.BaseActivity;
import com.example.idnp_proyecto.Interface.Inicio;
import com.example.idnp_proyecto.Model.InicioModel;
import com.example.idnp_proyecto.Presenter.InicioPresenter;
import com.example.idnp_proyecto.R;
import com.example.idnp_proyecto.Adaptadores.VPAdapter;
import com.google.android.material.tabs.TabLayout;

public class InicioView extends BaseActivity<InicioPresenter> implements Inicio {

    private TabLayout tabMenu;
    private ViewPager viewPager;
    protected  InicioPresenter createPresenter(@NonNull Context context){
        return new InicioPresenter(this,new InicioModel());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        tabMenu = findViewById(R.id.tabMenu);
        viewPager = findViewById(R.id.viewPager);

        tabMenu.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new RutasView(), getResources().getString(R.string.textAll));
        vpAdapter.addFragment(new FavoritosView(), getResources().getString(R.string.textFavorites));
        vpAdapter.addFragment(new CercanosView(), getResources().getString(R.string.textNear));
        viewPager.setAdapter(vpAdapter);
    }

    @Override
    public void mostrarInicio() {

    }

    @Override
    public void ocultarInicio() {

    }

    @Override
    public void mostrarTabMenu() {

    }

    @Override
    public void ocultarTabMenu() {

    }

    @Override
    public void mostrarviewPager() {

    }

    @Override
    public void ocultarViewPager() {

    }
}