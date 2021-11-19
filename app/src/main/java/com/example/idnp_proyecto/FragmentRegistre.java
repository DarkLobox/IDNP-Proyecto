package com.example.idnp_proyecto;

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

public class FragmentRegistre extends Fragment {

    Button buttonReg;
    EditText regName,regCorreo,regCelular,regPass,verPass;
    String nombre,correo,celular,pass,verifi;
    SharedPreferences.Editor editor;

    public void onAttach(@NonNull Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userFile",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registre_fragment,container,false);
        buttonReg = view.findViewById(R.id.registre);
        regName = view.findViewById(R.id.registrarNombre);
        regCorreo = view.findViewById(R.id.registrarCorreo);
        regCelular = view.findViewById(R.id.registrarCelular);
        regPass = view.findViewById(R.id.registrarPassword);
        verPass = view.findViewById(R.id.verificarPassword);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre= regName.getText().toString();
                correo=regCorreo.getText().toString();
                celular=regCelular.getText().toString();
                pass= regPass.getText().toString();
                verifi=verPass.getText().toString();

                editor.putString("nombre",nombre);
                editor.putString("correo",correo);
                editor.putString("celular",celular);
                editor.putString("pass",pass);
                editor.apply();
                Toast.makeText(getContext(),"Registrado", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
