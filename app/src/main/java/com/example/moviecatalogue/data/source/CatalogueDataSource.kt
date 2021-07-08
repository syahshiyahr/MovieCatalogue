package com.example.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.local.entity.TVShow
import com.example.moviecatalogue.vo.Resource

interface CatalogueDataSource {
    fun getAllMovies(): LiveData<Resource<List<Movie>>>

    fun getAllTVShows(): LiveData<Resource<List<TVShow>>>

    fun getDetailMovie(movieId: Int): LiveData<Resource<Movie>>

    fun getDetailTVShow(tvshowsId: Int): LiveData<Resource<TVShow>>

    fun setMoviesBookmark(movies: Movie, state: Boolean)

    fun setTVShowBookmark(tvShow: TVShow, state: Boolean)

    fun getBookmarkMovies(): LiveData<List<Movie>>

    fun getBookmarkTVShow(): LiveData<List<TVShow>>

}