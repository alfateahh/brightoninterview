package com.example.brighton.api

import com.example.brighton.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDbApi {
    @GET("/")
    fun searchMovies(
        @Query("s") title: String,
        @Query("apikey") apiKey: String
    ): Call<MovieResponse>
}
