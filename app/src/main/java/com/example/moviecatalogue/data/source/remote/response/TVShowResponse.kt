package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class TVShowResponse (
    @SerializedName("results")
    var results: MutableList<TVShowEntity>
)