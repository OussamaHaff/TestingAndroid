package com.hfrsoussama.testingandroid.view

import android.os.Looper.getMainLooper
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hfrsoussama.testingandroid.R
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.LooperMode
import org.robolectric.annotation.LooperMode.Mode.PAUSED

@RunWith(AndroidJUnit4::class)
@LooperMode(PAUSED) // see : http://robolectric.org/blog/2019/06/04/paused-looper/
class MainActivityUnitTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `when launched, activity should be in a resumed state`() {
        val scenario = activityScenarioRule.scenario

        shadowOf(getMainLooper()).idle()
        Assert.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun `when searching "ad", activity  be in a resumed state`() {
        val scenario = activityScenarioRule.scenario

        onView(withId(R.id.etSearchInput)).perform(typeText("ad"))
        onView(withId(R.id.btnSearch)).perform(click())

        onView(withId(R.id.citiesRecyclerView))
            .perform(RecyclerViewActions.scrollToPosition<CitiesAdapter.ViewHolder>(0))


        //TODO add missing assert
        shadowOf(getMainLooper()).idle()

    }




}