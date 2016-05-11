package com.mw3dk.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.adapter.MedicalteamAdapter;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.DrawerFragment;
import com.mw3dk.pojo.AllPojos;
import com.mw3dk.utils.DividerItemDecoration;
import com.mw3dk.utils.RecyclerItemClickListener;
import com.mw3dk.utils.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by snyxius on 3/5/16.
 */
public class MedicalTeamResultActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
Toolbar toolbar;
    MedicalteamAdapter adapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    //    ListView mylist;
    TextView empty,createnewtext;
    private LinearLayoutManager layoutManager;

    Button done;
    ArrayList<AllPojos> estTypeListArray;
    @Optional
    @InjectView(R.id.toolbar_title) TextView toolbartxt ;

    List<AllPojos> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicaltmresult);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_drawer, new DrawerFragment(), Constants.DRAWER_FRAGMENT)
                .commit();

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


        adapter = new MedicalteamAdapter(this,estTypeListArray);
        mRecyclerView.setAdapter(adapter);

//        mRecyclerView.addOnItemTouchListener(
//                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
////
//                    }
//                })
//        );

    }




}
