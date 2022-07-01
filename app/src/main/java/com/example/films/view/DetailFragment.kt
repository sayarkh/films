package com.example.films.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.films.IMAGE_BASE
import com.example.films.model.MovieApiService
import com.example.films.model.MovieDetails
import retrofit2.Call
import com.example.films.databinding.FragmentDetailBinding
import com.example.films.model.MovieResponse
import com.example.films.view_model.DetailFragmentViewModel
import com.example.films.view_model.MainFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*
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
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailFragmentViewModel::class.java)
        viewModel.getMovieDetailsData(args.movieId)
        viewModel.getMovie().observe(viewLifecycleOwner, Observer<MovieDetails> { movie ->
            binding.tvDate.text = movie.release_date
            binding.tvTitle.text = movie.title
            binding.tvDescription.text = movie.overview
            Glide.with(requireContext()).load(IMAGE_BASE + movie.poster_path).into(binding.imgDetail)
        })
    }

}