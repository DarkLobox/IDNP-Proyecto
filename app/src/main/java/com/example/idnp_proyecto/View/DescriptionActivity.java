package com.example.idnp_proyecto.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.idnp_proyecto.R;

public class DescriptionActivity extends AppCompatActivity {

    TextView titleDescriptionTextView;
    TextView rutaDescriptionTextview;
    TextView statusDescriptionTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Ruta element = (Ruta) getIntent().getSerializableExtra("Ruta");
        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        rutaDescriptionTextview = findViewById(R.id.rutaDescriptionTextview);
        statusDescriptionTextview = findViewById(R.id.statusDescriptionTextview);

        titleDescriptionTextView.setText(element.getEmpresa());


        rutaDescriptionTextview.setText(element.getLetraRuta());


        statusDescriptionTextview.setText(element.getHorario());

    }
}