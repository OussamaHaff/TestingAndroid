package com.hfrsoussama.testingandroid.view

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.hfrsoussama.testingandroid.R
import org.junit.Rule
import org.junit.Test
import java.util.regex.Matcher
import java.util.regex.Pattern.matches

class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun countDisplayedCities() {
        onView(
            withId(R.id.citiesRecyclerView)
        ).check(
            matches(hasItemCount(10))
        )
    }

    class CustomMatchers {
        companion object {
            fun withItemCount(count: Int): Matcher<View> {
            }
        }
    }
}