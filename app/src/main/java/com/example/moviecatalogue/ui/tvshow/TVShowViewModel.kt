package com.example.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.CatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.TVShow
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.vo.Resource

class TVShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getTVShow() : LiveData<Resource<List<TVShow>>> = catalogueRepository.getAllTVShows()
}