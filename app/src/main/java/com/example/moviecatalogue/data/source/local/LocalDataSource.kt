package com.example.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.local.entity.TVShow
import com.example.moviecatalogue.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

    fun getAllMovies(): LiveData<List<Movie>> = mCatalogueDao.getMovies()

    fun getBookmarkedMovies(): LiveData<List<Movie>> = mCatalogueDao.getBookmarkedMovie()

    fun getAllTVShow(): LiveData<List<TVShow>> = mCatalogueDao.getTVShow()

    fun getBookmarkedTVShow(): LiveData<List<TVShow>> = mCatalogueDao.getBookmarkedTVShow()

    fun getMoviesById(movieId: Int): LiveData<Movie> =
        mCatalogueDao.getMovieById(movieId)

    fun getTVShowById(tvShowId: Int): LiveData<TVShow> =
        mCatalogueDao.getTVShowById(tvShowId)

    fun insertMovie(movies: List<Movie>) = mCatalogueDao.insertMovies(movies)

    fun insertTVShow(tvShow: List<TVShow>) = mCatalogueDao.insertTVShow(tvShow)

    fun setMoviesBookmark(movies: Movie, newState: Boolean) {
        movies.bookmarked = newState
        mCatalogueDao.updateMovie(movies)
    }

    fun setTVShowBookmark(tvShow: TVShow, newState: Boolean) {
        tvShow.bookmarked = newState
        mCatalogueDao.updateTVShow(tvShow)
    }

}