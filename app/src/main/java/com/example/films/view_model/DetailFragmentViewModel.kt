package com.example.films.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.films.model.MovieApiService
import com.example.films.model.MovieDetails
import com.example.films.view.DetailFragmentArgs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragmentViewModel:ViewModel(){
    private val _movie: MutableLiveData<MovieDetails> = MutableLiveData()

    fun getMovie(): LiveData<MovieDetails> {
        return _movie
    }

    fun getMovieDetailsData(movieId: String) {
        val apiService = MovieApiService.getPostApi()
        apiService.getMovieDetails(movieId).enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                if (response.isSuccessful) {
                    _movie.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {

            }
        })
    }
}