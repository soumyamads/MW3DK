package com.mw3dk.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.activity.BookappointmentActivity;
import com.mw3dk.activity.MedicalTeam;
import com.mw3dk.activity.SearchResultActivity;
import com.mw3dk.activity.SignInActivity;
import com.mw3dk.activity.WellguideActivity;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Optional;


/**
 * Created by snyxius on 11/9/2015.
 */
public class DrawerFragment extends Fragment implements View.OnClickListener{

   static DrawerLayout drawerLayout;
    RelativeLayout rltvsignin,rltvjoinnw,rltvwelguide,reltvmedical;
    TextView medicltxt;
    ImageView mediclimg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.drawerlayout, container, false);
        return rootView;
    }


    public static  DrawerFragment newInstance(DrawerLayout drawer) {
        drawerLayout = drawer;
        DrawerFragment f = new DrawerFragment();
        return f;
    }


    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialise(view);

    }




    private void initialise(View view) {
        mediclimg=(ImageView)view.findViewById(R.id.medicltmimg);
        medicltxt=(TextView)view.findViewById(R.id.medicltxt);
        reltvmedical=(RelativeLayout)view.findViewById(R.id.relatv_medical);
        view.findViewById(R.id.relatv_medical).setOnClickListener(this);
        view.findViewById(R.id.medicltxt).setOnClickListener(this);
        view.findViewById(R.id.medicltmimg).setOnClickListener(this);
        view.findViewById(R.id.relative_signin).setOnClickListener(this);
        view.findViewById(R.id.signinimg).setOnClickListener(this);
        view.findViewById(R.id.signintxt).setOnClickListener(this);
        view.findViewById(R.id.relatv_welguide).setOnClickListener(this);
        view.findViewById(R.id.welgdtxt).setOnClickListener(this);
        view.findViewById(R.id.welguidimg).setOnClickListener(this);
        view.findViewById(R.id.reltvapointmnt).setOnClickListener(this);
        view.findViewById(R.id.pastapntimg).setOnClickListener(this);
        view.findViewById(R.id.patapttxt).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relatv_medical:
            case R.id.medicltmimg:
            case R.id.medicltxt:
                 Intent i=new Intent(getActivity(), MedicalTeam.class);
                startActivity(i);
                break;
            case R.id.signinimg:
            case R.id.signintxt:
            case R.id.relative_signin:
                Intent i1=new Intent(getActivity(), SignInActivity.class);
                startActivity(i1);
                break;
            case R.id.relatv_welguide:
            case R.id.welgdtxt:
            case R.id.welguidimg:
                Intent i3=new Intent(getActivity(), WellguideActivity.class);
                startActivity(i3);
                break;
            case R.id.reltvapointmnt:
            case R.id.pastapntimg:
            case R.id.patapttxt:
                Intent i4=new Intent(getActivity(), BookappointmentActivity.class);
                startActivity(i4);
                break;

        }
    }
}
