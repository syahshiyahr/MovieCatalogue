package com.example.moviecatalogue.utils

import com.example.moviecatalogue.BuildConfig
import com.example.moviecatalogue.utils.Constants.API_KEY

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = BuildConfig.API_KEY
    const val IMG_URL = "https://image.tmdb.org/t/p/w500"
}