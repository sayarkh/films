package com.example.films.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.films.R
import com.example.films.RecyclerViewItemClickListener
import com.example.films.model.MovieApiService
import com.example.films.model.Movie
import com.example.films.model.MovieResponse
import com.example.films.view_model.MainFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*
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
//        getMovieData {  movies: List<Movie> ->
//            rv_movies_list.adapter = MainAdapter(movies, listener)
//        }
        init()
    }

    fun init() {
        val viewModel = ViewModelProvider(this, defaultViewModelProviderFactory).get(MainFragmentViewModel::class.java)
        viewModel.getMovies().observe(this, Observer<MovieResponse> {
            if(it != null){
                rv_movies_list.adapter = MainAdapter(it.movies, listener)
            }
        })
    }

    private var listener = object: RecyclerViewItemClickListener {
        override fun onClickListener(movie: Movie, pos: Int) {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailFragment(
                    movie.id!!
                )
            )
        }
    }



}
