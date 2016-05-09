package com.mw3dk.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mw3dk.R;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.DrawerFragment;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by snyxius on 3/5/16.
 */
public class Wellguide_oneActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;
//    @Optional @InjectView(R.id.toolbar_title) TextView signintxt ;
//    @Optional @InjectView(R.id.text1) TextView text1 ;
//    @Optional @InjectView(R.id.text2) TextView text2 ;
    @Optional @OnClick(R.id.save)
    public void continue_click(){
        Intent i=new Intent(Wellguide_oneActivity.this,Wellguide_testActivity.class);
        startActivity(i);


    }
    static final String[] Months = new String[] { "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellguide1);
        ButterKnife.inject(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_drawer, new DrawerFragment(), Constants.DRAWER_FRAGMENT)
                .commit();


        initDrawer();
//        initialise();

        //spinner for year
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

        Spinner spinYear = (Spinner)findViewById(R.id.year);
        spinYear.setAdapter(adapter);


        //spinner  for month
        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Months);
        adapterMonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinMonths = (Spinner)findViewById(R.id.month);
        spinMonths.setAdapter(adapterMonths);

//progressdialog
    }

    private void initialise(){
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/AvenirNextLTPro-Regular.otf");
//        text1.setTypeface(face);
//        text2.setTypeface(face);


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
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
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
