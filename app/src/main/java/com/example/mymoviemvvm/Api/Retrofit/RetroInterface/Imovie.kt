package com.example.mymoviemvvm.Api.Retrofit.RetroInterface

import retrofit2.Call
import retrofit2.http.GET
import com.example.mymoviemvvm.Model.Resultt
import retrofit2.http.Query

interface Imovie {
    @GET("movie/popular?")
    fun movieGet(@Query("api_key") api_key: String): Call<Resultt>
}