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

public class FavoritosView extends Fragment {
    List<Ruta> rutas;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.favoritos_fragment, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerFavoritos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        rutas = new ArrayList<Ruta>();
        rutas.add(new Ruta("3 de Octubre", "A", "5:00 AM - 9:00 PM", false));
        rutas.add(new Ruta("4 de Octubre", "B", "5:00 AM - 9:00 PM", false));
        rutas.add(new Ruta("5 de Octubre", "D", "5:00 AM - 9:00 PM", false));

        databaseReference.child("RutaFavorita").setValue(rutas);
        //Recupera el valor de InicioView para verificar invitado
        boolean invitado = getActivity().getIntent().getBooleanExtra("Invitado", true);

        ListAdapter listAdapter;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            listAdapter = new ListAdapter(rutas, getContext(), new ListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Ruta item) {
                    moveToDescription(item);
                }
            }, invitado);
        }else{
            listAdapter = new ListAdapter(rutas, getContext(), new ListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Ruta item) {
                    Toast.makeText(rootView.getContext(), "Esta version es incompatible con esa funcion", Toast.LENGTH_SHORT).show();
                }
            }, invitado);
        }

        recyclerView.setAdapter(listAdapter);
        return rootView;
    }

    public  void moveToDescription(Ruta item){
        Intent intent = new Intent(getContext(), DescriptionView.class);
        intent.putExtra("Ruta",item);
        startActivity(intent);
    }

}