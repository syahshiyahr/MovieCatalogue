package com.example.moviecatalogue.data

import com.google.gson.annotations.SerializedName

data class TVShowEntity (
    @field: SerializedName("id")
    var tvShowId: Int,

    @field: SerializedName("original_name")
    var title: String,

    @field: SerializedName("overview")
    var desc: String,

    @field: SerializedName("first_air_date")
    var releaseDate: String,

    @field: SerializedName("vote_average")
    var rating: String,

    @field: SerializedName("poster_path")
    var image: String,
)