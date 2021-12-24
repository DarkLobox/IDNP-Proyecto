package com.example.idnp_proyecto.View;


import android.content.Context;
import android.content.Intent;
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

import com.example.idnp_proyecto.Base.BaseActivity;
import com.example.idnp_proyecto.Interface.CallbackFragment;
import com.example.idnp_proyecto.Interface.Login;
import com.example.idnp_proyecto.Model.InicioModel;
import com.example.idnp_proyecto.Model.LoginModel;
import com.example.idnp_proyecto.Presenter.InicioPresenter;
import com.example.idnp_proyecto.Presenter.LoginPresenter;
import com.example.idnp_proyecto.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginView extends Fragment implements Login {

    Button buttonLog,buttonReg,buttonInv;
    EditText etCorreo,etPass;
    CallbackFragment callbackFragment;
    String correo,pass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String uCorreo,uPass;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    boolean invitado = true, ingresar = false;
    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("userFile",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        etCorreo = view.findViewById(R.id.logName);
        etPass = view.findViewById(R.id.logPass);
        LoginPresenter presenter = new LoginPresenter();
        buttonLog = view.findViewById(R.id.logButton);
        buttonReg = view.findViewById(R.id.regButton);
        buttonInv = view.findViewById(R.id.invButton);
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(v);
            }
        });

        buttonInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitado = true;
                navigationHome();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callbackFragment!=null){
                    callbackFragment.changeFragment();
                }
            }
        });
        return view;
    }
    public void setCallbackFragment(CallbackFragment callbackFragment){
        this.callbackFragment = callbackFragment;
    }

    protected LoginPresenter createPresenter(@NonNull Context context) {
        return new LoginPresenter(this,new LoginModel());
    }

    @Override
    public void mostrarProgreso() {
        etCorreo.setVisibility(View.VISIBLE);
        etPass.setVisibility(View.VISIBLE);
        buttonLog.setVisibility(View.VISIBLE);
        buttonReg.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgreso() {
        etCorreo.setVisibility(View.GONE);
        etPass.setVisibility(View.GONE);
        buttonLog.setVisibility(View.GONE);
        buttonReg.setVisibility(View.GONE);
    }

    @Override
    public void errorUsuario() {
        etCorreo.setError("Campo Obligatorio");
    }

    @Override
    public void errorContraseña() {
        etPass.setError("Campo Obligatorio");
    }

    @Override
    public void navigationHome() {
        Toast.makeText(getContext(),"ingreso", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), InicioView.class);
        intent.putExtra("Invitado",invitado);
        startActivity(intent);
    }
    public void validar(View v){

        correo=etCorreo.getText().toString();
        pass=etPass.getText().toString();

        uCorreo = sharedPreferences.getString("correo",null);
        uPass = sharedPreferences.getString("pass", null);
        ingresar=false;

        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Usuario");
        databaseReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                int i=1;
                while(i<=Usuario.cantidad){
                    uCorreo= task.getResult().child(i+"/correo").getValue().toString();
                    uPass= task.getResult().child(i+"/password").getValue().toString();
                    if(correo.equals(uCorreo) && pass.equals(uPass)){
                        ingresar=true;
                        break;
                    }
                    i++;
                }
            }
        });

        if(correo.equals(uCorreo) && pass.equals(uPass) ){
            invitado = false;
            navigationHome();
        }else{
            Toast.makeText(getContext(),"datos Erroneos", Toast.LENGTH_SHORT).show();
        }
    }
}
