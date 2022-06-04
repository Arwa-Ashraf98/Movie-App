package com.example.mvvmandmovieapi.Movie.app.data.Network;


import com.example.mvvmandmovieapi.Movie.app.data.Models.ModelMovie;
import com.example.mvvmandmovieapi.Movie.app.data.Models.ModelMovieDetails;

import io.reactivex.Single;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitServices {


    @GET("discover/movie")
    Single<ModelMovie> getAllMoviesRx (@Query("api_key") String api_key);

    @GET("movie/{movie_id}")
    Single<ModelMovieDetails> getMovieDetailsRx(@Path("movie_id") int movieId, @Query("api_key") String api_key);
}
