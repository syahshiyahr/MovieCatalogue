package com.example.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.NetworkBoundResource
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.local.entity.TVShow
import com.example.moviecatalogue.data.source.remote.ApiResponse
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.RemoteDataSource
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.vo.Resource

class CatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteData, localData, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Movie>> =
                localDataSource.getAllMovies()


            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieEntity>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MovieEntity>) {
                val movieList = ArrayList<Movie>()
                for (response in data){
                    val movie = Movie(
                        response.movieId,
                        response.title,
                        response.desc,
                        response.releaseDate,
                        response.rating,
                        response.image,
                        false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTVShows(): LiveData<Resource<List<TVShow>>> {
        return object : NetworkBoundResource<List<TVShow>, List<TVShowEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TVShow>> =
                localDataSource.getAllTVShow()


            override fun shouldFetch(data: List<TVShow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TVShowEntity>>> =
                remoteDataSource.getTVShow()

            override fun saveCallResult(data: List<TVShowEntity>) {
                val tvShowList = ArrayList<TVShow>()
                for (response in data){
                    val tvShow = TVShow(
                        response.tvShowId,
                        response.title,
                        response.desc,
                        response.releaseDate,
                        response.rating,
                        response.image,
                        false
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTVShow(tvShowList)
            }
        }.asLiveData()
    }


    override fun getDetailMovie(movieId: Int): LiveData<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, MovieEntity>(appExecutors){
            override fun loadFromDB(): LiveData<Movie> =
                localDataSource.getMoviesById(movieId)

            override fun shouldFetch(data: Movie?): Boolean =
                data != null

            override fun createCall(): LiveData<ApiResponse<MovieEntity>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: MovieEntity) {
                val movie = Movie(
                            data.movieId,
                            data.title,
                            data.desc,
                            data.releaseDate,
                            data.rating,
                            data.image,
                    false
                        )
                localDataSource.setMoviesBookmark(movie, false)
            }
        }.asLiveData()

    }

    override fun getDetailTVShow(tvShowId: Int): LiveData<Resource<TVShow>> {
        return object : NetworkBoundResource<TVShow, TVShowEntity>(appExecutors){
            override fun loadFromDB(): LiveData<TVShow> =
                localDataSource.getTVShowById(tvShowId)

            override fun shouldFetch(data: TVShow?): Boolean =
                data != null

            override fun createCall(): LiveData<ApiResponse<TVShowEntity>> =
                remoteDataSource.getDetailTVShow(tvShowId)

            override fun saveCallResult(data: TVShowEntity) {
                val tvShow = TVShow(
                    data.tvShowId,
                    data.title,
                    data.desc,
                    data.releaseDate,
                    data.rating,
                    data.image,
                    false
                )
                localDataSource.setTVShowBookmark(tvShow, false)
            }
        }.asLiveData()

    }

    override fun setMoviesBookmark(movies: Movie, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setMoviesBookmark(movies, state)
        }
    }

    override fun setTVShowBookmark(tvShow: TVShow, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setTVShowBookmark(tvShow, state)
        }
    }

    override fun getBookmarkMovies(): LiveData<List<Movie>> =
        localDataSource.getBookmarkedMovies()


    override fun getBookmarkTVShow(): LiveData<List<TVShow>> =
        localDataSource.getBookmarkedTVShow()
}