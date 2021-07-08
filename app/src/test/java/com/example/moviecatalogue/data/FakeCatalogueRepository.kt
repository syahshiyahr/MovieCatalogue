package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.CatalogueDataSource
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.RemoteDataSource

class FakeCatalogueRepository (private val remoteDataSource: RemoteDataSource) : CatalogueDataSource {

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val moviesResponses = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(movies: List<MovieEntity>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movies != null){
                    for (response in movies) {
                        val movie = MovieEntity(response.movieId,
                            response.title,
                            response.desc,
                            response.releaseDate,
                            response.rating,
                            response.image
                        )
                        movieList.add(movie)
                    }
                    moviesResponses.postValue(movieList)
                }
            }

        })
        return moviesResponses

    }

    override fun getAllTVShows(): LiveData<List<TVShowEntity>> {
        val tvShowResponses = MutableLiveData<List<TVShowEntity>>()
        remoteDataSource.getTVShow(object : RemoteDataSource.LoadTVShowCallback{
            override fun onAllTVShowReceived(tvShows: List<TVShowEntity>?) {
                val tvShowList = ArrayList<TVShowEntity>()
                if (tvShows != null){
                    for (response in tvShows) {
                        val tvShow = TVShowEntity(response.tvShowId,
                            response.title,
                            response.desc,
                            response.releaseDate,
                            response.rating,
                            response.image
                        )
                        tvShowList.add(tvShow)
                    }
                    tvShowResponses.postValue(tvShowList)
                }
            }

        })
        return tvShowResponses
    }

    override fun getDetailMovie(movieId: Int): LiveData<MovieEntity> {
        val movieDetailResponse = MutableLiveData<MovieEntity>()

        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMoviesCallback{
            override fun onDetailMovieReceived(movieResponse: MovieEntity?) {
                if (movieResponse!=null){
                    val movie = MovieEntity(movieResponse.movieId,
                        movieResponse.title,
                        movieResponse.desc,
                        movieResponse.releaseDate,
                        movieResponse.rating,
                        movieResponse.image
                    )
                    movieDetailResponse.postValue(movie)
                }
            }

        })
        return movieDetailResponse

    }

    override fun getDetailTVShow(tvshowsId: Int): LiveData<TVShowEntity> {
        val tvShowDetailResponse = MutableLiveData<TVShowEntity>()

        remoteDataSource.getDetailTVShow(tvshowsId, object : RemoteDataSource.LoadDetailTVShowCallback{
            override fun onDetailTVShowReceived(tvShowResponse: TVShowEntity?) {
                if (tvShowResponse!=null){
                    val tvShow = TVShowEntity(tvShowResponse.tvShowId,
                        tvShowResponse.title,
                        tvShowResponse.desc,
                        tvShowResponse.releaseDate,
                        tvShowResponse.rating,
                        tvShowResponse.image
                    )
                    tvShowDetailResponse.postValue(tvShow)
                }
            }


        })
        return tvShowDetailResponse
    }
}