package com.example.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.source.CatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.remote.ApiConfig
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.vo.Resource

class MoviesViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getMovies() : LiveData<Resource<List<Movie>>> = catalogueRepository.getAllMovies()

}