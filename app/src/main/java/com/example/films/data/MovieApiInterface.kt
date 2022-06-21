package com.example.films.data

import com.example.films.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=5b2ce55d1f51bb12a7eef170b626eb71")
    fun getMovieList(): Call<MovieResponse>
}