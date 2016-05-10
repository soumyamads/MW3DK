package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mw3dk.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by soumya on 5/8/2016.
 */
public class Insurance_info extends AppCompatActivity implements View.OnClickListener{
//Spinner day,year,month;
    static final String[] Months = new String[] { "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance_info);
        findViewById(R.id.insurance_save).setOnClickListener(this);
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.backicon).setOnClickListener(this);


        //spinner seting year
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

        Spinner spinYear = (Spinner)findViewById(R.id.year);
        spinYear.setAdapter(adapter);


        // Set months
        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Months);
        adapterMonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinMonths = (Spinner)findViewById(R.id.month);
        spinMonths.setAdapter(adapterMonths);
        // Set days
        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapterDays = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);

        Spinner spinDays = (Spinner)findViewById(R.id.date);
        spinDays.setAdapter(adapterDays);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insurance_save:

                Intent i = new Intent(Insurance_info.this, HomeActivity.class);
                startActivity(i);
                finish();
                break;

            case R.id.close:
            case R.id.backicon:

                Intent i1 = new Intent(Insurance_info.this, EmergencyContact.class);
                startActivity(i1);
                finish();
                break;
        }
    }


}
