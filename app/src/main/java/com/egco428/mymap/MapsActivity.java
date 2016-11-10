package com.egco428.mymap;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        setUpMap();
    }

    private void setUpMap() {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(15, 100), 8));



        mMap.addMarker(new MarkerOptions().position(new LatLng(13.7934, 100.3225)).title("Mahidol"));


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title(latLng.toString()));
            }
        });

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.1123, 100.05612))
                .title("Nomal Marker")
                .snippet("content"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.4231,100.45612))
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                .title("Nomal Color Marker")
                .snippet("content"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(15, 100.45612))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("Nomal Green Marker")
                .snippet("content"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.55234, 100))
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                .title("Custom Marker")
                .snippet("content"));

        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(15.55234, 100), new LatLng(15.4231,100.45612), new LatLng(15, 100.45612),
                     new LatLng(13.7934, 100.3225), new LatLng(15.1123, 100.05612), new LatLng(15.55234, 100))
                .width(5)
                .color(Color.RED));
    }
}
