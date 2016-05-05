package com.mw3dk.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mw3dk.R;

/**
 * Created by snyxius on 5/5/16.
 */
public class DoctorProfileAdapter extends RecyclerView.Adapter<DoctorProfileAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;
    private int[] mDataSetTypes;
    private LayoutInflater mInflater;

    public static final int DOCTOR_PROF_HEADER = 0;
    public static final int MAP_MIDDLE = 1;
    public static final int BOTTOM_LAYOUT = 2;
Context mcontext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class WeatherViewHolder extends ViewHolder {
        TextView temp;

        public WeatherViewHolder(View v) {
            super(v);
//            this.temp = (TextView) v.findViewById(R.id.temp);
        }
    }

    public class ScoreViewHolder extends ViewHolder {
        TextView score;
        ViewPager pager;
        TabLayout tabLayout;

        public ScoreViewHolder(View v) {
            super(v);
//            this.score = (TextView) v.findViewById(R.id.score);
            pager= (ViewPager)v. findViewById(R.id.view_pager);
            tabLayout= (TabLayout) v.findViewById(R.id.tab_layout);
        }
    }

    public class NewsViewHolder extends ViewHolder {
        TextView headline;
        Button read_more;

        public NewsViewHolder(View v) {
            super(v);
//            this.headline = (TextView) v.findViewById(R.id.headline);
//            this.read_more = (Button) v.findViewById(R.id.read_more);
        }
    }


    public DoctorProfileAdapter(Context context,String[] dataSet) {
        mDataSet = dataSet;
//        mDataSetTypes = dataSetTypes;
mcontext=context;    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == DOCTOR_PROF_HEADER) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.doctor_profile, viewGroup, false);

            return new WeatherViewHolder(v);
        } else if (viewType == MAP_MIDDLE) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.map, viewGroup, false);
            return new NewsViewHolder(v);
        }
        else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.viewpager, viewGroup, false);
            return new ScoreViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (viewHolder.getItemViewType() == DOCTOR_PROF_HEADER) {
            WeatherViewHolder holder = (WeatherViewHolder) viewHolder;
//            holder.temp.setText(mDataSet[position]);
        }
        else if (viewHolder.getItemViewType() == MAP_MIDDLE) {
            NewsViewHolder holder = (NewsViewHolder) viewHolder;
//            holder.headline.setText(mDataSet[position]);
        }
        else {
            ScoreViewHolder holder = (ScoreViewHolder) viewHolder;
//            holder.score.setText(mDataSet[position]);

            // Fragment manager to add fragment in viewpager we will pass object of Fragment manager to adpater class.
            FragmentManager manager= ((AppCompatActivity)mcontext).getSupportFragmentManager();

            //object of PagerAdapter passing fragment manager object as a parameter of constructor of PagerAdapter class.
            PagerAdapter adapter=new PagerAdapter(manager);

            //set Adapter to view pager
            holder.pager.setAdapter(adapter);

            //set tablayout with viewpager
          holder.  tabLayout.setupWithViewPager(holder.pager);

            // adding functionality to tab and viewpager to manage each other when a page is changed or when a tab is selected
          holder.  pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(holder.tabLayout));

            //Setting tabs from adpater
//          holder.  tabLayout.setTabsFromPagerAdapter(adapter);

        }
    }



    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    @Override
    public int getItemViewType(int position) {
//        return mDataSetTypes[position];
        if(position==0){
            return DOCTOR_PROF_HEADER;
        }
        else if(position==1){
            return MAP_MIDDLE;
        }
        else if(position==2){
            return BOTTOM_LAYOUT;

        }
        return 3;
    }
}
