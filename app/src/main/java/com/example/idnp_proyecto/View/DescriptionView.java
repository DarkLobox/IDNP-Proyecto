package com.example.idnp_proyecto.View;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.idnp_proyecto.R;
import com.example.idnp_proyecto.databinding.ActivityDescriptionBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

public class DescriptionView extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityDescriptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Ruta element = (Ruta) getIntent().getSerializableExtra("Ruta");
        Toast.makeText(this, element.getEmpresa() + "\n" + element.getHorario() + "\n" + element.getLetraRuta(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        createMarker(googleMap);
        createPolylines(googleMap);
    }

    private final void createMarker(GoogleMap googleMap) {
        LatLng coordinates = new LatLng(-16.422089710019176D, -71.54356956481934D);
        MarkerOptions marker = (new MarkerOptions()).position(coordinates).title("Ruta 01");
        googleMap.addMarker(marker);
        googleMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(coordinates, 15.0F), 2000, null);
    }

    private final void createPolylines(GoogleMap googleMap) {
        PolylineOptions ruta01 = (new PolylineOptions())
                .add(new LatLng(-16.422089710019176D, -71.54356956481934D))
                .add(new LatLng(-16.41937282645092D, -71.53696060180664D))
                .add(new LatLng(-16.41649124178671D, -71.53223991394043D))
                .add(new LatLng(-16.412127618011656D, -71.52563095092773D))
                .add(new LatLng(-16.410645610309327D, -71.51309967041016D))
                .add(new LatLng(-16.40282371597893D, -71.51644706726074D))
                .add(new LatLng(-16.398048089097795D, -71.52400016784668D))
                .add(new LatLng(-16.408998921843207D, -71.5374755859375D))
                .add(new LatLng(-16.40570550310118D, -71.54013633728027D))
                .add(new LatLng(-16.433039189141063D, -71.5634822845459D))
                .color(Color.parseColor("#cc1010"))
                .width(20.0F);

        Polyline polyline = googleMap.addPolyline(ruta01);

        polyline.setStartCap(new RoundCap());
        polyline.setEndCap(new RoundCap());
    }
}