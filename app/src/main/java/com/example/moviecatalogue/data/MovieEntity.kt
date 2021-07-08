package com.example.moviecatalogue.data

import com.google.gson.annotations.SerializedName

data class MovieEntity (
    @field: SerializedName("id")
    val movieId: Int,

    @field: SerializedName("original_title")
    var title: String,

    @field: SerializedName("overview")
    var desc: String,

    @field: SerializedName("release_date")
    var releaseDate: String?,

    @field: SerializedName("vote_average")
    var rating: String,

    @field: SerializedName("poster_path")
    var image: String?
    )