package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mw3dk.R;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.AuthorizationsFragment;
import com.mw3dk.fragments.DemographicFragment;
import com.mw3dk.fragments.NotificationSettingsFragment;
import com.mw3dk.fragments.PasswordFragment;
import com.mw3dk.fragments.PatientInformationFragment;
import com.mw3dk.fragments.ProfileFragment;
import com.mw3dk.fragments.SettingsFragment;

/**
 * Created by soumya on 5/8/2016.
 */
public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{


    Button agree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
//        findViewById(R.id.agree).setOnClickListener(this);
        findViewById(R.id.backicon).setOnClickListener(this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_drawer, new SettingsFragment(), Constants.APPOINTMENT)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
