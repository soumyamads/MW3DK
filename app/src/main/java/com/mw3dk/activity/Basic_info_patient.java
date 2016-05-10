package com.mw3dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mw3dk.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by soumya on 5/8/2016.
 */
public class Basic_info_patient extends AppCompatActivity implements View.OnClickListener {
    static final String[] Months = new String[] { "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    static final String[] spnre = new String[] {"Select",
            "Male", "Female" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_info_patient);
        findViewById(R.id.save).setOnClickListener(this);
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.backicon).setOnClickListener(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //spinner seting year
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= 2030; i++) {
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


        Spinner spinr = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spnre);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//         attaching data adapter to spinner
        spinr.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:

                Intent i = new Intent(Basic_info_patient.this, Contact_info_patient.class);
                startActivity(i);
                finish();
                break;
            case R.id.close:
            case R.id.backicon:

                Intent i1 = new Intent(Basic_info_patient.this, Checkin.class);
                startActivity(i1);
                finish();
                break;
        }
    }

    }

