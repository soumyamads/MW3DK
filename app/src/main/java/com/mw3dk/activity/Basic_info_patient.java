package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mw3dk.R;

/**
 * Created by soumya on 5/8/2016.
 */
public class Basic_info_patient extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_info_patient);
        findViewById(R.id.save).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:

                Intent i = new Intent(Basic_info_patient.this, Contact_info_patient.class);
                startActivity(i);
                break;
        }
    }

    }

