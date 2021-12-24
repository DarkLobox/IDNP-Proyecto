package com.example.idnp_proyecto.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.idnp_proyecto.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SingUpView extends Fragment {

    Button buttonReg;
    EditText regName,regCorreo,regCelular,regPass,verPass;
    String nombre,correo,celular,pass,verifi;
    SharedPreferences.Editor editor;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    public void onAttach(@NonNull Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userFile",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sing_up_fragment,container,false);
        buttonReg = view.findViewById(R.id.registre);
        regName = view.findViewById(R.id.registrarNombre);
        regCorreo = view.findViewById(R.id.registrarCorreo);
        regCelular = view.findViewById(R.id.registrarCelular);
        regPass = view.findViewById(R.id.registrarPassword);
        verPass = view.findViewById(R.id.verificarPassword);


        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario user = new Usuario();

                nombre= regName.getText().toString();
                user.setNombre(regName.getText().toString());

                correo=regCorreo.getText().toString();
                user.setCorreo(regCorreo.getText().toString());

                celular=regCelular.getText().toString();
                user.setCelular(regCelular.getText().toString());


                pass= regPass.getText().toString();
                user.setPassword(regPass.getText().toString());

                verifi=verPass.getText().toString();

                editor.putString("nombre",nombre);
                editor.putString("correo",correo);
                editor.putString("celular",celular);
                editor.putString("pass",pass);
                editor.apply();

                databaseReference.child("Usuario").child(String.valueOf(Usuario.cantidad++)).setValue(user);

                Toast.makeText(getContext(),"Registrado", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}

class Usuario {

    private String nombre;
    private String correo;
    private String celular;
    private String Password;
    public static int cantidad=1;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return nombre;
    }
}