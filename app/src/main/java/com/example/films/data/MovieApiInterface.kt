package com.example.films.data

import com.example.films.models.MovieDetails
import com.example.films.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import io.reactivex.rxjava3.core.Single

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=5b2ce55d1f51bb12a7eef170b626eb71")
    fun getMovieList(): Call<MovieResponse>

    @GET("/3/movie/{movie_id}?api_key=5b2ce55d1f51bb12a7eef170b626eb71")
    fun getMovieDetails(@Path("movie_id")id: String): Call<MovieDetails>

}