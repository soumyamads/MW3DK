package com.mw3dk.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.mw3dk.activity.BookappointmentActivity;
import com.mw3dk.activity.Checkin;

/**
 * Created by snyxius on 5/5/16.
 */
public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;
    private int[] mDataSetTypes;
    private LayoutInflater mInflater;

    public static final int UPCOME_PROF_HEADER = 0;
    public static final int MAP_MIDDLE_LAYOUT = 1;
    public static final int BOTTOM_LAYOUT = 2;
Context mcontext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class WeatherViewHolder extends ViewHolder {
        TextView temp;
//        Button nextavailability;

        public WeatherViewHolder(View v) {
            super(v);
//            this.temp = (TextView) v.findViewById(R.id.temp);
//            this.nextavailability=(Button)v.findViewById(R.id.nextavailblty);
        }
    }

    public class ScoreViewHolder extends ViewHolder {
        TextView score;
//        ViewPager pager;
//        TabLayout tabLayout;
        Button checkin;

        public ScoreViewHolder(View v) {
            super(v);

            this.checkin = (Button) v.findViewById(R.id.checkin);
//            pager= (ViewPager)v. findViewById(R.id.view_pager);
//            tabLayout= (TabLayout) v.findViewById(R.id.tab_layout);
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


    public UpcomingAdapter(Context context, String[] dataSet) {
        mDataSet = dataSet;
//        mDataSetTypes = dataSetTypes;
mcontext=context;    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == UPCOME_PROF_HEADER) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.upcoming_toplayout, viewGroup, false);

            return new WeatherViewHolder(v);
        } else if (viewType == MAP_MIDDLE_LAYOUT) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.map, viewGroup, false);
            return new NewsViewHolder(v);
        }
        else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.upcoming_bottom_layout, viewGroup, false);
            return new ScoreViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (viewHolder.getItemViewType() == UPCOME_PROF_HEADER) {
            WeatherViewHolder holder = (WeatherViewHolder) viewHolder;

//            holder.temp.setText(mDataSet[position]);

        }
        else if (viewHolder.getItemViewType() == MAP_MIDDLE_LAYOUT) {
            NewsViewHolder holder = (NewsViewHolder) viewHolder;
//            holder.headline.setText(mDataSet[position]);
        }
        else {
            ScoreViewHolder holder = (ScoreViewHolder) viewHolder;
//            holder.score.setText(mDataSet[position]);

                holder.checkin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(mcontext,Checkin.class);
                        mcontext.startActivity(i);
                    }
                });
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
            return UPCOME_PROF_HEADER;
        }
        else if(position==1){
            return MAP_MIDDLE_LAYOUT;
        }
        else if(position==2){
            return BOTTOM_LAYOUT;

        }
        return 3;
    }
}
