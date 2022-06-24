package com.example.films.moviedetails.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.films.IMAGE_BASE
import com.example.films.R
import com.example.films.data.MovieApiInterface
import com.example.films.data.MovieApiService
import com.example.films.models.MovieDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import com.example.films.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.card_layout.view.*
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMovieDetailsData { movie: MovieDetails ->
            binding.tvDate.text = movie.release_date
            binding.tvTitle.text = movie.title
            binding.tvDescription.text = movie.overview
            Glide.with(requireContext()).load(IMAGE_BASE + movie.poster_path).into(binding.imgDetail)
        }
    }

    private fun getMovieDetailsData(callback: (MovieDetails) -> Unit) {
        val apiService = MovieApiService.getPostApi()
        apiService.getMovieDetails(args.movieId).enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                if (response.isSuccessful) {
                    return callback(response.body()!!)
                }
            }
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {

            }

        }

        )
    }

}