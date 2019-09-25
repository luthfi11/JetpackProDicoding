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

class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {

    }

    @Test
    fun testAppBehaviour() {
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))

        Thread.sleep(1000)
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                9
            )
        )

        Thread.sleep(1500)
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                9,
                click()
            )
        )

        Thread.sleep(1500)
        pressBack()

        Thread.sleep(1500)
        onView(withId(R.id.viewPager)).perform(swipeLeft())

        Thread.sleep(1500)
        onView(withId(R.id.rvTV)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                9
            )
        )

        Thread.sleep(1500)
        onView(withId(R.id.rvTV)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                9,
                click()
            )
        )

        Thread.sleep(1000)
        pressBack()

        Thread.sleep(1000)
    }
}