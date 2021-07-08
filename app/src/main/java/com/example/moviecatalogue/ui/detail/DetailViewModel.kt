package com.example.moviecatalogue.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.CatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.local.entity.TVShow
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.vo.Resource

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {


    private lateinit var movie: LiveData<Resource<Movie>>
    private lateinit var tvShow: LiveData<Resource<TVShow>>


    fun setSelectedItem(itemId: Int, category: String) {
        if (category.equals("Movies", true)) {
            movie = catalogueRepository.getDetailMovie(itemId)
        } else if (category.equals("TV Show", true)) {
            tvShow = catalogueRepository.getDetailTVShow(itemId)
        }
    }


    fun getMovie() = movie
    fun getTVShow() = tvShow

    fun setBookmarkMovies() {
        val movieResource = movie.value
        if (movieResource?.data != null) {
            val newState = !movieResource.data.bookmarked
            catalogueRepository.setMoviesBookmark(movieResource.data, newState)

        }
    }

    fun setBookmarkTVShow() {
        val tvShowResource = tvShow.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data.bookmarked
            catalogueRepository.setTVShowBookmark(tvShowResource.data, newState)

        }
    }

}