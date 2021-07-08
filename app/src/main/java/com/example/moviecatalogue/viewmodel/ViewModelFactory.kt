package com.example.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecatalogue.data.source.CatalogueRepository
import com.example.moviecatalogue.di.Injection
import com.example.moviecatalogue.ui.bookmark.movie.MovieBookmarkViewModel
import com.example.moviecatalogue.ui.bookmark.tvshow.TVShowBookmarkViewModel
import com.example.moviecatalogue.ui.detail.DetailViewModel
import com.example.moviecatalogue.ui.movie.MoviesViewModel
import com.example.moviecatalogue.ui.tvshow.TVShowViewModel

class ViewModelFactory private constructor(private val catalogueRepository: CatalogueRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                return TVShowViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(MovieBookmarkViewModel::class.java) -> {
                return MovieBookmarkViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(TVShowBookmarkViewModel::class.java) -> {
                return TVShowBookmarkViewModel(catalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}