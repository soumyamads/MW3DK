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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.adapter.SearchResultAdapter;
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
public class InsuranceActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;


    private LinearLayoutManager layoutManager;

    Button done;
    ArrayList<AllPojos> estTypeListArray;
    @Optional
    @InjectView(R.id.toolbar_title) TextView toolbartxt ;

    List<AllPojos> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance_layout);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }




}
