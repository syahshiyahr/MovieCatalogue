package com.example.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.RemoteDataSource
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import com.nhaarman.mockitokotlin2.any


class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val movieResponse = DataDummy.generateDummyMovie()
    private val movieId = movieResponse[0].movieId
    private val detailMovieResponse = movieResponse[0]
    private val tvShowResponse = DataDummy.generateDummyTVShow()
    private val tvShowId = tvShowResponse[0].tvShowId
    private val detailTVShowResponse = tvShowResponse[0]

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMoviesReceived(
                movieResponse
            )
            null
        }.`when`(remote).getMovies(any())


        val movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())

    }

    @Test
    fun getAllTVShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTVShowCallback).onAllTVShowReceived(
                tvShowResponse
            )
            null
        }.`when`(remote).getTVShow(any())

        val tvShowEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllTVShows())
        verify(remote).getTVShow(any())

        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())

    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMoviesCallback).onDetailMovieReceived(
                detailMovieResponse
            )
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val moviesEntities = LiveDataTestUtil.getValue(catalogueRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())

        assertNotNull(moviesEntities)
        assertEquals(detailMovieResponse, moviesEntities)

    }

    @Test
    fun getDetailTVShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTVShowCallback).onDetailTVShowReceived(
                detailTVShowResponse
            )
            null
        }.`when`(remote).getDetailTVShow(eq(tvShowId), any())

        val tvShowEntities = LiveDataTestUtil.getValue(catalogueRepository.getDetailTVShow(tvShowId))
        verify(remote).getDetailTVShow(eq(tvShowId), any())

        assertNotNull(tvShowEntities)
        assertEquals(detailTVShowResponse, tvShowEntities)

    }
}