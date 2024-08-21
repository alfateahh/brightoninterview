package com.example.brighton.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brighton.api.RetrofitInstance
import com.example.brighton.model.Movie
import com.example.brighton.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val apiKey = "9012e95c"

    fun searchMovies(title: String) {
        RetrofitInstance.api.searchMovies(title, apiKey).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful && response.body()?.Response == "True") {
                    _movies.value = response.body()?.Search
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                // Handle error
            }
        })
    }
}
