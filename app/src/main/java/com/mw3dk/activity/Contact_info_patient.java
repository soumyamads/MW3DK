package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mw3dk.R;

/**
 * Created by soumya on 5/8/2016.
 */
public class Contact_info_patient extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info);
        findViewById(R.id.contactsave).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.contactsave:

                Intent i = new Intent(Contact_info_patient.this, EmergencyContact.class);
                startActivity(i);
                break;
        }
    }

    }

