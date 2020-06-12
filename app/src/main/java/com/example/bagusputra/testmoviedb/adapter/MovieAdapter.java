package com.example.bagusputra.testmoviedb.adapter;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bagusputra.testmoviedb.R;
import com.example.bagusputra.testmoviedb.object.Result;
import com.example.bagusputra.testmoviedb.activity.DetailMovieActivity;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    List<Result> results;

    public MovieAdapter(List<Result> results) {
        this.results = results;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_movie, parent, false);
        return new MovieHolder(view);

    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, final int position) {
        Picasso.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w185/" + results.get(position).getPosterPath())
                .into(holder.postermovieinitial);
        holder.texttitleinitial.setText("Title : "+results.get(position).getTitle());
        holder.textratinginitial.setText("Rating : "+Double.toString(results.get(position).getVoteAverage()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result data = results.get(position);
                Intent i = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
                i.putExtra("movie", new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivity(i);
                Log.d("PopularActivity",Double.toString(results.get(position).getId()));
            }
        });

    }

    public void setData(List<Result> results) {
        this.results = results;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        ImageView postermovieinitial;
        TextView texttitleinitial;
        TextView textratinginitial;

        public MovieHolder(View itemView) {
            super(itemView);
            postermovieinitial = (ImageView) itemView.findViewById(R.id.postermovieinitial);
            texttitleinitial = (TextView) itemView.findViewById(R.id.texttitleinitial);
            textratinginitial = (TextView) itemView.findViewById(R.id.textratinginitial);
        }
    }
}
