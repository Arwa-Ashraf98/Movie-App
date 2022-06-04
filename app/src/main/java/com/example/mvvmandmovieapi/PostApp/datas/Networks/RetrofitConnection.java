package com.example.mvvmandmovieapi.PostApp.datas.Networks;

import retrofit2.Retrofit;

public class RetrofitConnection {

    private static Retrofit retrofit2 ;


    private static Retrofit getRetrofit2(){

        if (retrofit2==null){

        }
        return retrofit2;
    }
}
