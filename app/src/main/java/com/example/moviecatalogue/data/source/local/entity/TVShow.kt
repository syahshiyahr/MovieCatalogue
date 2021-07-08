package com.example.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tvShowEntities")
data class TVShow(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "overview")
    var desc: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false
)