package com.mw3dk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.mw3dk.R;
import com.mw3dk.activity.BookappointmentActivity;
import com.mw3dk.pojo.AllPojos;

import java.util.List;

/**
 * Created by amanjham on 13/01/16.
 */
public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder> {

    private List<AllPojos> moviesList;
    Button nextavailability;


    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            nextavailability = (Button) view.findViewById(R.id.nextavailblty);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public SearchResultAdapter(Context mcontext, List<AllPojos> moviesList) {
        context=mcontext;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.searchlist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Movie movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
        nextavailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, BookappointmentActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
//        return moviesList.size();
        return 3;
    }
}