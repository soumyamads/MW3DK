package com.mw3dk.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


;import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mw3dk.R;

/**
 * Created by Paul on 8/11/15.
 */
public class MapDealsFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    static int count = 0;
    public static MapDealsFragment newInstance(int position) {
        count = position;
        Bundle args = new Bundle();
        MapDealsFragment fragment = new MapDealsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.map, null, false);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

    private void initialize(View view) {
//        if(count == Constants.INT_ONE) {
//            view.findViewById(R.id.down_arrow1).setVisibility(View.GONE);
//        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons(R.drawable.map_marker, 40, 50))));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    public Bitmap resizeMapIcons(int iconName,int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),iconName);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}