package com.example.idnp_proyecto.View;

import java.io.Serializable;

public class Ruta implements Serializable {
    public String empresa;
    public String letraRuta;
    public String horario;
    public boolean favorito;

    public Ruta(String empresa,String letraRuta,String horario, boolean favorito){
        this.empresa = empresa;
        this.letraRuta = letraRuta;
        this.horario = horario;
        this.favorito = favorito;
    }
    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLetraRuta() {
        return letraRuta;
    }

    public void setLetraRuta(String letraRuta) {
        this.letraRuta = letraRuta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
