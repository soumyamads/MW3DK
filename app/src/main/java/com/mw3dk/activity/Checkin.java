package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mw3dk.R;

/**
 * Created by soumya on 5/8/2016.
 */
public class Checkin extends AppCompatActivity implements View.OnClickListener{


    Button agree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkin);
        findViewById(R.id.agree).setOnClickListener(this);
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.backicon).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.agree:

                Intent i = new Intent(Checkin.this, Basic_info_patient.class);
                startActivity(i);
                finish();
                break;
            case R.id.close:
            case R.id.backicon:

                Intent i1 = new Intent(Checkin.this, Upcoming_Activity.class);
                startActivity(i1);
                finish();
                break;
        }
    }
}
