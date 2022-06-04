package com.example.mvvmandmovieapi.Movie.app.data.Network;

import com.example.mvvmandmovieapi.Movie.app.helper.Const;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class
RetrofitConnection {
    private static Retrofit retrofit;

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL_MOVIES)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
    public static RetrofitServices getServices (){
        return getRetrofit().create(RetrofitServices.class);
    }
}
