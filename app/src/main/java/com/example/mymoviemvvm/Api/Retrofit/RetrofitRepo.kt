package com.example.mymoviemvvm.Api.Retrofit

import com.example.mymoviemvvm.Api.Retrofit.RetroInterface.Imovie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitRepo {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val api: Imovie by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Imovie::class.java)
    }
}