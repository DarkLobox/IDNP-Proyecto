package com.example.idnp_proyecto.Interface;

public interface Usuario {
    interface View{
        void showFragment();
    }
    interface Presenter{
        void addFragment();
        void showFragment();
    }
    interface Model{
        void addFragment();
    }
}
