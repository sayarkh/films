package com.example.films.moviedetails.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.films.R
import com.example.films.RecyclerViewItemClickListener
import com.example.films.data.MainAdapter
import com.example.films.data.MovieApiInterface
import com.example.films.data.MovieApiService
import com.example.films.models.Movie
import com.example.films.models.MovieResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movies_list.setHasFixedSize(true)
        getMovieData {  movies: List<Movie> ->
            rv_movies_list.adapter = MainAdapter(movies, listener)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getPostApi()
        apiService.getMovieList().enqueue(object: Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }

    private var listener = object: RecyclerViewItemClickListener {
        override fun onClickListener(movie: Movie, pos: Int) {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(movie.id!!))
        }
    }

}
