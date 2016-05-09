package com.mw3dk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.activity.MedicalAppointment;
import com.mw3dk.pojo.AllPojos;

import java.util.List;

/**
 * Created by amanjham on 13/01/16.
 */
public class MedicalteamAdapter extends RecyclerView.Adapter<MedicalteamAdapter.MyViewHolder> {

    private List<AllPojos> moviesList;

Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView appointment, year, genre;
        RelativeLayout apnt;
        ImageView rightarw;

        public MyViewHolder(View view) {
            super(view);
            appointment = (TextView) view.findViewById(R.id.appointment);
            rightarw=(ImageView)view.findViewById(R.id.rightarw);

            apnt=(RelativeLayout)view.findViewById(R.id.reltv1);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MedicalteamAdapter(Context mcontext, List<AllPojos> moviesList) {
        context=mcontext;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medicalteam_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Movie movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
        holder.appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,MedicalAppointment.class);
                context.startActivity(i);
            }
        });
        holder.apnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(context,MedicalAppointment.class);
                context.startActivity(i1);
            }
        });
        holder.rightarw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(context,MedicalAppointment.class);
                context.startActivity(i1);
            }
        });

    }

    @Override
    public int getItemCount() {
//        return moviesList.size();
        return 3;
    }
}