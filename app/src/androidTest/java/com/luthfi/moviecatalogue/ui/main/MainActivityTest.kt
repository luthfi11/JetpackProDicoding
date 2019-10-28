package com.luthfi.moviecatalogue.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.luthfi.moviecatalogue.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.luthfi.moviecatalogue.utils.EspressoIdlingResource
import androidx.test.espresso.IdlingRegistry
import org.junit.After


class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun testAppBehaviour() {
        onView(withId(R.id.bottomNav)).check(matches(isDisplayed()))

        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                9
            )
        )
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                9,
                click()
            )
        )
        onView(withId(R.id.addToFav)).perform(click())

        pressBack()

        onView(withId(R.id.navTVShow)).perform(click())
        onView(withId(R.id.rvTV)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                9
            )
        )
        onView(withId(R.id.rvTV)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                9,
                click()
            )
        )
        onView(withId(R.id.addToFav)).perform(click())

        pressBack()

        onView(withId(R.id.navFavorite)).perform(click())
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.addToFav)).perform(click())

        pressBack()
        onView(withId(R.id.viewPager)).perform(swipeLeft())
    }
}