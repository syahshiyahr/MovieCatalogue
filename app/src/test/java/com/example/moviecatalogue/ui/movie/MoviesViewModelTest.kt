package com.example.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.MovieEntity
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
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp(){
        viewModel = MoviesViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMovies().value
        verify(catalogueRepository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}