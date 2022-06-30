package com.example.films.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse (
    @SerializedName("details")
    val movieDetails: List<MovieDetails>
)// : Parcelable {
//    constructor(): this(mutableListOf())
//}