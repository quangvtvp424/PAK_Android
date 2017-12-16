package com.ptit.pak_android_course.lesson08;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.ptit.pak_android_course.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_less08);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Silicon Vallley
        // 37.3876° N, 123.0575° W
        LatLng siliconValley = new LatLng(37.3876,238.0575);
        map.addMarker(new MarkerOptions().position(siliconValley).title("Silicon Valley"));
        map.moveCamera(CameraUpdateFactory.newLatLng(siliconValley));
    }
}

