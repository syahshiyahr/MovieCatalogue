package com.example.moviecatalogue.ui.bookmark.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.source.CatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.Movie

class MovieBookmarkViewModel (private val repository: CatalogueRepository) : ViewModel() {
    fun getBookmarkMovie(): LiveData<List<Movie>> = repository.getBookmarkMovies()
}