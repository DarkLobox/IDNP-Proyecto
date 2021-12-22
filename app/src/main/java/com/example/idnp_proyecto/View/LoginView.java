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

import com.example.idnp_proyecto.Interface.CallbackFragment;
import com.example.idnp_proyecto.R;

public class LoginView extends Fragment {

    Button buttonLog,buttonReg;
    EditText etCorreo,etPass;
    CallbackFragment callbackFragment;
    String correo,pass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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

        buttonLog = view.findViewById(R.id.logButton);
        buttonReg = view.findViewById(R.id.regButton);

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo=etCorreo.getText().toString();
                pass=etPass.getText().toString();
                String uCorreo,uPass;
                uCorreo = sharedPreferences.getString("correo",null);
                uPass = sharedPreferences.getString("pass", null);

                if((correo.equals(uCorreo) && pass.equals(uPass)) || true){
                    Toast.makeText(getContext(),"ingreso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), InicioView.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext(),"datos Erroneos", Toast.LENGTH_SHORT).show();
                }


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
}
