package com.example.films

import com.example.films.models.Movie

interface RecyclerViewItemClickListener {
    fun onClickListener(movie: Movie, pos: Int)
}