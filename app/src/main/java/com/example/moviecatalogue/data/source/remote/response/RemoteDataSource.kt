package com.example.moviecatalogue.data.source.remote.response

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.remote.ApiConfig
import com.example.moviecatalogue.data.source.remote.ApiResponse
import com.example.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource{

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
    fun getMovies(): LiveData<ApiResponse<List<MovieEntity>>> {
        EspressoIdlingResource.increment()

        val client = ApiConfig.getApiService().allMovies()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieEntity>>>()

        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                resultMovies.value = ApiResponse.success(response.body()?.results as List<MovieEntity>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
            }
        })
        return resultMovies
    }

    fun getTVShow() : LiveData<ApiResponse<List<TVShowEntity>>> {
        EspressoIdlingResource.increment()

        val client = ApiConfig.getApiService().allTvShows()
        val resultTVShow = MutableLiveData<ApiResponse<List<TVShowEntity>>>()
        client.enqueue(object : Callback<TVShowResponse> {
            override fun onResponse(
                call: Call<TVShowResponse>,
                response: Response<TVShowResponse>
            ) {
                resultTVShow.value = ApiResponse.success(response.body()?.results as List<TVShowEntity>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTVShow onFailure : ${t.message}")
            }

        })
        return resultTVShow
    }

    fun getDetailMovie(movieId: Int) : LiveData<ApiResponse<MovieEntity>> {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().detailMovie(movieId)
        val resultDetailMovie = MutableLiveData<ApiResponse<MovieEntity>>()

        client.enqueue(object : Callback<MovieEntity> {
            override fun onResponse(call: Call<MovieEntity>, response: Response<MovieEntity>) {
                resultDetailMovie.value = ApiResponse.success(response.body() as MovieEntity)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieEntity>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailMovie onFailure : ${t.message}")
            }


        })
        return resultDetailMovie
    }

    fun getDetailTVShow(tvShowId: Int) : LiveData<ApiResponse<TVShowEntity>> {
        EspressoIdlingResource.increment()

        val client = ApiConfig.getApiService().detailTvShow(tvShowId)
        val resultDetailTVShow = MutableLiveData<ApiResponse<TVShowEntity>>()

        client.enqueue(object : Callback<TVShowEntity> {
            override fun onResponse(call: Call<TVShowEntity>, response: Response<TVShowEntity>) {
                resultDetailTVShow.value = ApiResponse.success(response.body() as TVShowEntity)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TVShowEntity>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailTVShow onFailure : ${t.message}")
            }


        })
        return resultDetailTVShow
    }


    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieEntity>?)
    }
    interface LoadTVShowCallback {
        fun onAllTVShowReceived(tvShowResponses: List<TVShowEntity>?)
    }
    interface LoadDetailMoviesCallback {
        fun onDetailMovieReceived(movieResponse: MovieEntity?)
    }
    interface LoadDetailTVShowCallback {
        fun onDetailTVShowReceived(tvShowResponse: TVShowEntity?)
    }
}