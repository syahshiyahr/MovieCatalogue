package com.example.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.local.entity.TVShow

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM movieEntities")
    fun getMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movieEntities where bookmarked = 1")
    fun getBookmarkedMovie(): LiveData<List<Movie>>

    @Query("SELECT * FROM tvShowEntities")
    fun getTVShow(): LiveData<List<TVShow>>

    @Query("SELECT * FROM tvShowEntities where bookmarked = 1")
    fun getBookmarkedTVShow(): LiveData<List<TVShow>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShow(tvShow: List<TVShow>)

    @Update
    fun updateTVShow(tvShow: TVShow)

    @Query("SELECT * FROM movieEntities WHERE movieId = :movieId")
    fun getMovieById(movieId: Int): LiveData<Movie>

    @Query("SELECT * FROM tvShowEntities WHERE tvShowId = :tvShowId")
    fun getTVShowById(tvShowId: Int): LiveData<TVShow>

}