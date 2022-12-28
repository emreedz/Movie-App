package com.example.mymoviemvvm.Model

import com.google.gson.annotations.SerializedName


data class Resultt(
    @SerializedName("results")
    val results: List<MovieResponse>
)
