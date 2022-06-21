package com.example.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.films.data.MovieApiInterface
import com.example.films.data.MovieApiService
import com.example.films.models.Movie
import com.example.films.models.MovieResponse
import com.example.films.data.MainAdapter
import com.example.films.databinding.ActivityMainBinding
import com.example.films.screens.MainFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainFragment = MainFragment()
        setThatFragment(mainFragment)

//        binding.rvMoviesList.setHasFixedSize(true)
//        getMovieData { movies: List<Movie> ->
//            binding.rvMoviesList.adapter = MainAdapter(movies)
//        }
    }

//    private fun getMovieData(callback: (List<Movie>) -> Unit) {
//        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
//        apiService.getMovieList().enqueue(object: Callback<MovieResponse> {
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//            }
//            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//                return callback(response.body()!!.movies)
//            }
//        })
//    }

    private fun setThatFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }

}