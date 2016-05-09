package com.mw3dk.activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.adapter.AnimalsAdapter;
import com.mw3dk.adapter.SearchResultAdapter;
import com.mw3dk.pojo.AllPojos;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by snyxius on 9/5/16.
 */
public class SelectSpecialityLayout extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    Toolbar toolbar;
    SearchResultAdapter adapter;
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
        setContentView(R.layout.speciality_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);



//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.container_drawer, new DrawerFragment(), Constants.DRAWER_FRAGMENT)
//                .commit();

//        initDrawer();
//        initRecyclerView();
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
//        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        drawerToggle.onConfigurationChanged(newConfig);
    }
    private void initRecyclerView() {
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
//        estTypeListArray = new ArrayList<>();
//
//        AllPojos cp = new AllPojos();
//        cp.setDrname("alvdn");
//        cp.setValues("dental");
//        cp.setPlcname("dffdf");
//
//
//
//        estTypeListArray.add(cp);
        final AnimalsHeadersAdapter adapter = new AnimalsHeadersAdapter();
        adapter.add("Animals below!");
        adapter.addAll(getDummyDataSet());
        mRecyclerView.setAdapter(adapter);

//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(layoutManager);
//
//        //add ItemDecoration
//        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(2));
//        //or
//        mRecyclerView.addItemDecoration(
//                new DividerItemDecoration(this));
//        //or
//        mRecyclerView.addItemDecoration(
//                new DividerItemDecoration(this, R.drawable.divider));
//        adapter = new SearchResultAdapter(this,estTypeListArray);
//        mRecyclerView.setAdapter(adapter);
//
//        mRecyclerView.addOnItemTouchListener(
//                new com.mw3dk.utils.RecyclerItemClickListener(this, new com.mw3dk.utils.RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
////
//                        Intent i=new Intent(InsuranceMainLayout.this,Doctor_Profile_Activity.class);
//                        startActivity(i);
//                    }
//                })
//        );



    }
    private String[] getDummyDataSet() {
        return getResources().getStringArray(R.array.animals);
    }

    private class AnimalsHeadersAdapter extends AnimalsAdapter<RecyclerView.ViewHolder>
            implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_item, parent, false);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView textView = (TextView) holder.itemView;
            textView.setText(getItem(position));
        }

        @Override
        public long getHeaderId(int position) {
            if (position == 0) {
                return -1;
            } else {
                return getItem(position).charAt(0);
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_header, parent, false);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView textView = (TextView) holder.itemView;
            textView.setText(String.valueOf(getItem(position).charAt(0)));
            holder.itemView.setBackgroundColor(getRandomColor());
        }

        private int getRandomColor() {
            SecureRandom rgen = new SecureRandom();
            return Color.HSVToColor(150, new float[]{
                    rgen.nextInt(359), 1, 1
            });
        }
    }

    }