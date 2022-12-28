package com.example.mymoviemvvm.MVVM

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymoviemvvm.Api.Retrofit.RetrofitRepo
import com.example.mymoviemvvm.Model.MovieResponse
import com.example.mymoviemvvm.Model.Resultt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BestViewModel : ViewModel() {

    private var moviesLiveData = MutableLiveData<List<MovieResponse>>()

    fun getBestMovie() {
        RetrofitRepo.api.movieGet("59db27673035a94b40de4a5151895a56")
            .enqueue(object : Callback<Resultt> {
                override fun onResponse(call: Call<Resultt>, response: Response<Resultt>) {
                    if (response.body() != null) {
                        moviesLiveData.value = response.body()!!.results
                    } else {
                        return
                    }
                }

                override fun onFailure(call: Call<Resultt>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

    fun observeMovieLiveData(): MutableLiveData<List<MovieResponse>> {
        return moviesLiveData
    }
}


