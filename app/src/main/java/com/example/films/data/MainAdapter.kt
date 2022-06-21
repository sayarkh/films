package com.example.films.data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.films.R
import com.example.films.models.Movie
import kotlinx.android.synthetic.main.card_layout.view.*

class MainAdapter(
    private val movies: List<Movie>
): RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MovieViewHolder(v)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: Movie) {
            itemView.item_title.text = movie.title
            itemView.item_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.item_img)
        }
    }

}