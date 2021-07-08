package com.example.moviecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviecatalogue.ui.home.HomeActivity
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTVShow = DataDummy.generateDummyTVShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies(){
        Espresso.onView(withId(R.id.rv_movies))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadTVShow(){
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size))
        Espresso.onView(ViewMatchers.withText("Movies")).perform(ViewActions.click())
    }

    @Test
    fun loadDetailMovie(){
        Espresso.onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))

        Espresso.onView(withId(R.id.tv_type))
            .check(ViewAssertions.matches(ViewMatchers.withText("Movies")))
        Espresso.onView(withId(R.id.tv_date))
            .check(ViewAssertions.matches(withText(dummyMovie[0].releaseDate)))
        Espresso.onView(withId(R.id.tv_rating))
            .check(ViewAssertions.matches(withText(dummyMovie[0].rating)))
        Espresso.onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(withText(dummyMovie[0].title)))
        Espresso.onView(withId(R.id.text_overview))
            .check(ViewAssertions.matches(withText(dummyMovie[0].desc)))
        Espresso.onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withContentDescription(R.string.abc_action_bar_up_description))
            .perform(ViewActions.click())
    }

    @Test
    fun loadDetailTVShow(){
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size))
        Espresso.onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))

        Espresso.onView(withId(R.id.tv_type))
            .check(ViewAssertions.matches(ViewMatchers.withText("TV Show")))
        Espresso.onView(withId(R.id.tv_date))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].releaseDate)))
        Espresso.onView(withId(R.id.tv_rating))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].rating)))
        Espresso.onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].title)))
        Espresso.onView(withId(R.id.text_overview))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].desc)))
        Espresso.onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}