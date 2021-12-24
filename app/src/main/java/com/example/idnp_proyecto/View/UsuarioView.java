package com.example.idnp_proyecto.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.idnp_proyecto.Interface.CallbackFragment;
import com.example.idnp_proyecto.Interface.Usuario;
import com.example.idnp_proyecto.Presenter.UsuarioPresenter;
import com.example.idnp_proyecto.R;

public class UsuarioView extends AppCompatActivity implements CallbackFragment, Usuario.View{

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private Usuario.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        presenter = new UsuarioPresenter(this);
        addFragment();
    }
    public void addFragment(){
        LoginView fragment=new LoginView();
        fragment.setCallbackFragment(this);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();
    }

    public void remplaceFragment(){
        fragment=new SingUpView();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void changeFragment() {
        remplaceFragment();
    }

    @Override
    public void showFragment() {

    }
}