package com.example.idnp_proyecto.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.idnp_proyecto.R;
import com.example.idnp_proyecto.ViewBarChart;

import java.util.ArrayList;
import java.util.List;

public class GraficoView extends Fragment {
    View rootview ;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.grafico_fragment, container, false);

        List<String> horizontal = new ArrayList<String>();
        horizontal.add("Usuarios");
        horizontal.add("Rutas");
        horizontal.add("Favoritos");

        List<Integer> vertical = new ArrayList<Integer>();
        vertical.add(60);
        vertical.add(20);
        vertical.add(65);

        ViewBarChart grafico = rootview.findViewById(R.id.grafico);
        grafico.setDatos(horizontal,vertical);

        return rootview;
    }


}
