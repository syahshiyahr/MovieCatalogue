package com.example.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.CatalogueRepository
import com.example.moviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<TVShowEntity>>


    @Before
    fun setUp(){
        viewModel = TVShowViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyTVShow = DataDummy.generateDummyTVShow()
        val tvShow = MutableLiveData<List<TVShowEntity>>()
        tvShow.value = dummyTVShow

        `when`(catalogueRepository.getAllTVShows()).thenReturn(tvShow)
        val moviesEntities = viewModel.getTVShow().value
        verify(catalogueRepository).getAllTVShows()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)
    }
}