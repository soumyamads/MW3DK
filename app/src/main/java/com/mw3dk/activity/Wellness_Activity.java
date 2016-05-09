package com.mw3dk.activity;

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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.DrawerFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by snyxius on 3/5/16.
 */
public class Wellness_Activity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();
//    @Optional @InjectView(R.id.toolbar_title) TextView signintxt ;
//    @Optional @InjectView(R.id.text1) TextView text1 ;
//    @Optional @InjectView(R.id.text2) TextView text2 ;
//
//
    @Optional @OnClick(R.id.save)
    public void continue_click(){
//        Intent i=new Intent(Wellness_Activity.this,Wellguide_testActivity.class);
//        startActivity(i);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellnessguide);
        ButterKnife.inject(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_drawer, new DrawerFragment(), Constants.DRAWER_FRAGMENT)
                .commit();
        initDrawer();
//        initialise();
        textView=(TextView)findViewById(R.id.value);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus + "/" + progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

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
