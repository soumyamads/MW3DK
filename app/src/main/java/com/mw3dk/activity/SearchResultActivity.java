package com.mw3dk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.adapter.SearchResultAdapter;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.DetailsFragment;
import com.mw3dk.fragments.DrawerFragment;
import com.mw3dk.pojo.AllPojos;
import com.mw3dk.utils.DividerItemDecoration;
import com.mw3dk.utils.VerticalSpaceItemDecoration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by snyxius on 9/5/16.
 */
public class SearchResultActivity  extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView mRecyclerView;
    Toolbar toolbar;
    SearchResultAdapter adapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    //    ListView mylist;
    TextView empty,datetxt;
    ImageView rightarw,leftarw;
    private LinearLayoutManager layoutManager;

    Button done;
    ArrayList<AllPojos> estTypeListArray;
    @Optional
    @InjectView(R.id.toolbar_title) TextView toolbartxt ;

    List<AllPojos> list = new ArrayList<>();
    Calendar c = Calendar.getInstance();

//    System.out.println("Current time => " + c.getTime());

    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_drawer, new DrawerFragment(), Constants.DRAWER_FRAGMENT)
                .commit();
        datetxt=(TextView)findViewById(R.id.date);
        rightarw=(ImageView)findViewById(R.id.rightarw);
        leftarw=(ImageView)findViewById(R.id.leftar);
        findViewById(R.id.rightarw).setOnClickListener(this);
        findViewById(R.id.leftar).setOnClickListener(this);

//        Calendar c = Calendar.getInstance();

        System.out.println("Current time => " + c.getTime());

//        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
//        String formattedDate = df.format(c.getTime());

        datetxt.setText(formattedDate);
        leftarw.setVisibility(View.GONE);

        initDrawer();
        initRecyclerView();
//        getlist();

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
    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
        estTypeListArray = new ArrayList<>();

        AllPojos cp = new AllPojos();
        cp.setDrname("alvdn");
        cp.setValues("dental");
        cp.setPlcname("dffdf");



        estTypeListArray.add(cp);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        //add ItemDecoration
//        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(2));
        //or
//        mRecyclerView.addItemDecoration(
//                new DividerItemDecoration(this));
        //or
//        mRecyclerView.addItemDecoration(
//                new DividerItemDecoration(this, R.drawable.divider));
        adapter = new SearchResultAdapter(this,estTypeListArray);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
//
                        Intent i=new Intent(SearchResultActivity.this,Doctor_Profile_Activity.class);
                        startActivity(i);
                    }
                })
        );

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rightarw:
                leftarw.setVisibility(View.VISIBLE);
                c.add(Calendar.DATE, 1);
                formattedDate = df.format(c.getTime());

                Log.v("NEXT DATE : ", formattedDate);
                datetxt.setText(formattedDate);
                break;

            case R.id.leftar:
                c.add(Calendar.DATE, -1);
                formattedDate = df.format(c.getTime());

                Log.v("PREVIOUS DATE : ", formattedDate);
                datetxt.setText(formattedDate);
                break;
        }
    }
}
