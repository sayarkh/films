package com.example.films.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.films.RecyclerViewItemClickListener
import com.example.films.model.Movie
import com.example.films.model.MovieApiService
import com.example.films.model.MovieResponse
import com.example.films.view.MainFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel:ViewModel() {
    private val movies: MutableLiveData<MovieResponse> by lazy {
        MutableLiveData<MovieResponse>().also {
            getMovieData()
        }
    }

    fun getMovies(): LiveData<MovieResponse> {
        return movies
    }

    private fun getMovieData() {
        val apiService = MovieApiService.getPostApi()
        apiService.getMovieList().enqueue(object: Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movies.postValue(response.body())
            }
        })
    }



}