package com.example.moviecatalogue.data.source.remote

import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TVShowResponse
import com.example.moviecatalogue.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular?api_key=$API_KEY")
    fun allMovies(): Call<MovieResponse>

    @GET("movie/{id}?api_key=$API_KEY")
    fun detailMovie(@Path("id") id: Int): Call<MovieEntity>

    @GET("tv/popular?api_key=$API_KEY")
    fun allTvShows(): Call<TVShowResponse>

    @GET("tv/{id}?api_key=$API_KEY")
    fun detailTvShow(@Path("id") id: Int): Call<TVShowEntity>
}