package com.example.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.MovieEntity
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
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.movieId
    private val dummyTVShow = DataDummy.generateDummyTVShow()[0]
    private val tvShowId = dummyTVShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TVShowEntity>

    @Before
    fun setUp(){
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getMovie() {
        val movies = MutableLiveData<MovieEntity>()
        movies.value = dummyMovie

        viewModel.setSelectedItem(movieId)

        `when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(movies)
        val movieEntity = viewModel.getMovie().value as MovieEntity
        verify(catalogueRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.image, movieEntity.image)
        assertEquals(dummyMovie.desc, movieEntity.desc)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.title, movieEntity.title)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)

    }

    @Test
    fun getTVShow() {
        val tvShow = MutableLiveData<TVShowEntity>()
        tvShow.value = dummyTVShow

        viewModel.setSelectedItem(tvShowId)

        `when`(catalogueRepository.getDetailTVShow(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTVShow().value as TVShowEntity
        verify(catalogueRepository).getDetailTVShow(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTVShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dummyTVShow.image, tvShowEntity.image)
        assertEquals(dummyTVShow.desc, tvShowEntity.desc)
        assertEquals(dummyTVShow.rating, tvShowEntity.rating)
        assertEquals(dummyTVShow.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTVShow.title, tvShowEntity.title)

        viewModel.getTVShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTVShow)

    }
}