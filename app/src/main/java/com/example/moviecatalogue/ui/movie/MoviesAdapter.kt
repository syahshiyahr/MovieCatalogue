package com.example.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.databinding.ItemsMovieBinding
import com.example.moviecatalogue.ui.detail.DetailActivity
import com.example.moviecatalogue.utils.Constants.IMG_URL

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<Movie>()

    fun setMovies(movies: List<Movie>?){
        if(movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    class MoviesViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            with(binding){
                tvTitle.text = movie.title
                tvDate.text = movie.releaseDate
                tvRating.text = movie.rating
                tvOverview.text = movie.desc
                Glide.with(itemView.context)
                    .load(IMG_URL + movie.image)
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, movie.movieId)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "Movies")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size
}