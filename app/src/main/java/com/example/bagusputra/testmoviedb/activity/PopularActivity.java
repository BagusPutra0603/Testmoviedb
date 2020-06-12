package com.example.bagusputra.testmoviedb.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bagusputra.testmoviedb.adapter.MovieAdapter;
import com.example.bagusputra.testmoviedb.object.Moviedb;
import com.example.bagusputra.testmoviedb.network.MoviedbApiClient;
import com.example.bagusputra.testmoviedb.network.MoviedbApiInterface;
import com.example.bagusputra.testmoviedb.R;
import com.example.bagusputra.testmoviedb.object.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularActivity extends AppCompatActivity {

    RecyclerView mView;
    MovieAdapter adapter;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        mView = (RecyclerView) findViewById(R.id.movieView);
        mView.setLayoutManager(new GridLayoutManager(PopularActivity.this,2));

        movieLoad();
    }

    private void movieLoad(){
        MoviedbApiInterface api = MoviedbApiClient.getRetrofit().create(MoviedbApiInterface.class);
        Call<Moviedb> call = api.getPopular();
        call.enqueue(new Callback<Moviedb>() {
            @Override
            public void onResponse(Call<Moviedb> call, Response<Moviedb> response) {
                Moviedb moviedb = response.body();
                adapter=new MovieAdapter(results);
                adapter.setData(moviedb.getResults());
                mView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Moviedb> call, Throwable t) {

            }
        });
    }

}
