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
public class Dental_Insurance_info extends AppCompatActivity implements View.OnClickListener {
    static final String[] Months = new String[] { "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };

    static final String[] spnretn = new String[] {"Select Relation",
            "Father", "Mother","Sister","Brother","Brother-in-Law","Mother-in-Law","Father-in-Law","Son","Daughter","Niece","Nephew"};

    static final String[] spninsurnc= new String[] {"Select",
            "aaaa", "bbbb","cccc","dddd","eeee","ffff","gggg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dental_insurance_info);
        findViewById(R.id.dentalsavebtn).setOnClickListener(this);
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.backicon).setOnClickListener(this);


        //Spinner for DOB
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

//Spinner for relation
        Spinner spinr = (Spinner)findViewById(R.id.spinnerrltn);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spnretn);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinr.setAdapter(dataAdapter);


        //spinner for insurance carrier
        Spinner spininsurancecarier = (Spinner)findViewById(R.id.spinnerinsrncarier);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spninsurnc);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spininsurancecarier.setAdapter(dataAdapter1);


        //spinner for insuranceplan
        Spinner spininsuranceplan = (Spinner)findViewById(R.id.insurncplnspnr);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spninsurnc);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spininsuranceplan.setAdapter(dataAdapter2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dentalsavebtn:
                Intent i=new Intent(Dental_Insurance_info.this,HomeActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.close:
            case R.id.backicon:

                Intent i1 = new Intent(Dental_Insurance_info.this, Insurance_info.class);
                startActivity(i1);
                finish();
                break;
        }

    }
}
