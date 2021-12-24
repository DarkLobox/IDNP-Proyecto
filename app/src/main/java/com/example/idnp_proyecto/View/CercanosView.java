package com.example.idnp_proyecto.View;

import android.Manifest;
import android.app.ActionBar;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.idnp_proyecto.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

public class CercanosView extends Fragment {
    private GoogleMap map;
    public static final int REQUEST_CODE_LOCATION = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cercanos_fragment, container, false);
        //createFragment();
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                createMarker();
                createPolylines();
                enableLocation();
            }
        });

        requestLocationPermission();

        return view;
    }

    private final void createPolylines() {
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

        Polyline polyline = map.addPolyline(ruta01);

        polyline.setStartCap(new RoundCap());
        polyline.setEndCap(new RoundCap());
    }

    private final void createMarker() {
        LatLng coordinates = new LatLng(-16.422089710019176D, -71.54356956481934D);
        MarkerOptions marker = (new MarkerOptions()).position(coordinates).title("Ruta 01");
        map.addMarker(marker);
        map.animateCamera(
                CameraUpdateFactory.newLatLngZoom(coordinates, 15.0F), 2000, null);
    }

    private final void enableLocation() {
        if (map != null) {
            if (isLocationPermissionGranted()) {
                map.setMyLocationEnabled(true);
            }

        }
    }

    private final boolean isLocationPermissionGranted() {
        return ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }


    private final void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(getContext(), "Acepta los permisos en configuracion", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case 0:
                if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Toast.makeText(getContext(), "Acepta los permisos en configuracion", Toast.LENGTH_SHORT).show();
                }
            default:
        }
    }
}