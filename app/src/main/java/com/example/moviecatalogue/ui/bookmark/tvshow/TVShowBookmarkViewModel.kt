package com.example.moviecatalogue.ui.bookmark.tvshow

import com.example.moviecatalogue.data.source.CatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.local.entity.TVShow

class TVShowBookmarkViewModel(private val repository: CatalogueRepository) {
    fun getBookmarkTVShow() = repository.getBookmarkTVShow()

    fun setBookmarkTVShow(tvShow: TVShow){
        val newState = !tvShow.bookmarked
        repository.setTVShowBookmark(tvShow, newState)
    }
}