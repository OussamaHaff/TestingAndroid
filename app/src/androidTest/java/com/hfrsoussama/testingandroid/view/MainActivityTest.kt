package com.hfrsoussama.testingandroid.view

import android.view.View
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun countDisplayedCities() {

    }


    class RecyclerViewMatcher(private val recyclerViewId: Int) {

        fun atPosition(position: Int) = atPositionOnView(position, -1)

        private fun atPositionOnView(position: Int, i: Int): Matcher<View> {

        }
    }
}