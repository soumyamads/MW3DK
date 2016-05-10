package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mw3dk.R;

/**
 * Created by soumya on 5/8/2016.
 */
public class MedicalAppointment extends AppCompatActivity implements View.OnClickListener{
RelativeLayout upcoming;
    LinearLayout upcomings;
    ImageView rightarw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apointmnt);
//        upcoming=(RelativeLayout)findViewById(R.id.reltvupcmg);
        upcomings=(LinearLayout)findViewById(R.id.linearupcmg);
        rightarw=(ImageView)findViewById(R.id.rightarw);
        findViewById(R.id.reltvupcmg).setOnClickListener(this);
        findViewById(R.id.linearupcmg).setOnClickListener(this);
        findViewById(R.id.rightarw).setOnClickListener(this);
        findViewById(R.id.backicon).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reltvupcmg:
            case R.id.linearupcmg:
            case R.id.rightarw:
                Intent i=new Intent(MedicalAppointment.this,Upcoming_Activity.class);
                startActivity(i);
                finish();
                break;
            case R.id.backicon:
                Intent i1=new Intent(MedicalAppointment.this,MedicalTeamResultActivity.class);
                startActivity(i1);
                finish();
                break;
        }
    }
}
