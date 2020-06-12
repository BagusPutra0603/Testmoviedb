package com.example.bagusputra.testmoviedb.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bagusputra.testmoviedb.R;
import com.example.bagusputra.testmoviedb.object.Result;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {

    ImageView postermovie;
    TextView titlemovie, ratingmovie, datemoview, overviewmovie,orlanguangemovie,reviewmovie,trailermoview;

    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        postermovie = (ImageView) findViewById(R.id.postermovie);
        titlemovie = (TextView) findViewById(R.id.titlemovie);
        datemoview = (TextView) findViewById(R.id.datemoview);
        overviewmovie = (TextView) findViewById(R.id.overviewmovie);
        ratingmovie = (TextView) findViewById(R.id.ratingmovie);
        orlanguangemovie = (TextView) findViewById(R.id.orlanguangemovie);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), Result.class);

        Picasso.with(DetailMovieActivity.this)
                .load("https://image.tmdb.org/t/p/w185/" + result.getPosterPath())
                .into(postermovie);
        titlemovie.setText("Title : "+result.getTitle());
        ratingmovie.setText("Rating : "+Double.toString(result.getVoteAverage()));
        datemoview.setText("Date Realease : "+result.getReleaseDate());
        overviewmovie.setText("Overview : \n"+result.getOverview());
        orlanguangemovie.setText("Original Languange : "+result.getOriginalLanguage());
    }
}
