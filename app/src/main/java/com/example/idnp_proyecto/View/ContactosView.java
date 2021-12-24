package com.example.idnp_proyecto.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.idnp_proyecto.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactosView extends Fragment {
    List<Contacto> contactos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.contact_fragment, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerContactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Adriel Arias", "aariasl@unsa.edu.pe", "954421243"));
        contactos.add(new Contacto("Luis Armando", "lgomezp@unsa.edu.pe", "975216425"));
        contactos.add(new Contacto("Patricio Dante", "pdantet@unsa.edu.pe", "975216544"));
        contactos.add(new Contacto("Johnnathan J.", "jramosb@unsa.edu.pe", "959842125"));


        return rootView;
    }

}