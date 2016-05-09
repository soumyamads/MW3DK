package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mw3dk.R;

/**
 * Created by soumya on 5/8/2016.
 */
public class Insurance_info extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance_info);
        findViewById(R.id.insurance_save).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insurance_save:

                Intent i = new Intent(Insurance_info.this, HomeActivity.class);
                startActivity(i);
                break;
        }
    }


}
