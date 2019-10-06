package com.hfrsoussama.testingandroid.view

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hfrsoussama.testingandroid.R
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()


    @Test
    fun testMainScreenCreation() {
        val scenario = activityScenarioRule.scenario

        Assert.assertEquals(Lifecycle.State.RESUMED, scenario.state)

    }

    @Test
    fun `testSearch`() {
        val scenario = activityScenarioRule.scenario

        onView(ViewMatchers.withId(R.id.etSearchInput)).perform(ViewActions.typeText("ad"))
        onView(ViewMatchers.withId(R.id.btnSearch)).perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.citiesRecyclerView))
            .perform(actionOnItemAtPosition<CitiesAdapter.ViewHolder>(0, ViewActions.longClick()))

        // TODO add missing assert
    }

}