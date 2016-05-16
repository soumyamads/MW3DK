package com.mw3dk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.DrawerFragment;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by snyxius on 3/5/16.
 */
public class JoinNowActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
//    @Optional @InjectView(R.id.toolbar_title) TextView signintxt ;
    @Optional @InjectView(R.id.fgtpaswd) TextView fgtpswdtxt ;
    @Optional @InjectView(R.id.text2) TextView kpsgntext ;
//    @Optional @InjectView(R.id.text1) TextView text1 ;
    @Optional @InjectView(R.id.text4) TextView text4 ;
    @Optional @InjectView(R.id.text3) TextView text3 ;

    static final String[] Months = new String[] { "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    static final String[] spnre = new String[] {"Select",
            "Male", "Female" };

    @Optional @OnClick(R.id.continuebtn)
    public void continue_click(){
        Intent i=new Intent(JoinNowActivity.this,HomeActivity.class);
        startActivity(i);
        finish();

    }
    @Optional @OnClick(R.id.signintxts)
    public void signintxt_click(){
        Intent i=new Intent(JoinNowActivity.this,SignInActivity.class);
        startActivity(i);
        finish();
    }
    @Optional @OnClick(R.id.backicon)
    public void back_click(){
        Intent i3=new Intent(JoinNowActivity.this,HomeActivity.class);
        startActivity(i3);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinnw_layout);
        ButterKnife.inject(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.container_drawer, new DrawerFragment(), Constants.DRAWER_FRAGMENT)
//                .commit();
//        initDrawer();
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

        initialise();

    }

    private void initialise(){
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/AvenirNextLTPro-Regular.otf");
//        fgtpswdtxt.setTypeface(face);
//        signintxt.setTypeface(face);
//        kpsgntext.setTypeface(face);
//        text1.setTypeface(face);
//        text3.setTypeface(face);
//        text4.setTypeface(face);



    }
    private void initDrawer() {
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        drawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
