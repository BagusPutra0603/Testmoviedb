package com.example.bagusputra.testmoviedb.network;


import com.example.bagusputra.testmoviedb.object.Moviedb;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviedbApiInterface {

    public static String DB_API = "75bf38d2599a50d3920f0f22105ebeec";

    @GET("popular?api_key=" + DB_API)
    Call<Moviedb> getPopular();


}
