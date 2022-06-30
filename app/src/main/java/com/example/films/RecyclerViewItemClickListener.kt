package com.example.films

import com.example.films.model.Movie

interface RecyclerViewItemClickListener {
    fun onClickListener(movie: Movie, pos: Int)
}