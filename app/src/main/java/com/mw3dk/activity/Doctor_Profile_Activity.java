package com.mw3dk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.adapter.DoctorProfileAdapter;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.DrawerFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by snyxius on 5/5/16.
 */
public class Doctor_Profile_Activity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    private RecyclerView mRecyclerView;

    private DoctorProfileAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataset = {"29 degrees", "Seahawks 24 - 27 Bengals",
            "Half Life 3 announced"};
//    private int mDatasetTypes[] = {WEATHER, SCORE, NEWS, NEWS}; //view types

    //    @Optional
//    @InjectView(R.id.toolbar_title)
//    TextView signintxt ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorprofile_main);
        ButterKnife.inject(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_drawer, new DrawerFragment(), Constants.DRAWER_FRAGMENT)
                .commit();
        initDrawer();
        initialise();
    }

    private void initialise(){
//        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/AvenirNextLTPro-Regular.otf");
//        speciality.setTypeface(face);
//        insurance.setTypeface(face);
//        aig.setTypeface(face);
//        location.setTypeface(face);
//        street.setTypeface(face);
//        physician.setTypeface(face);



        mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
//Adapter is created in the last step

        mAdapter = new DoctorProfileAdapter(Doctor_Profile_Activity.this,mDataset);
        mRecyclerView.setAdapter(mAdapter);



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
