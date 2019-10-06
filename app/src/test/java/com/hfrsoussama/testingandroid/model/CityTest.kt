package com.hfrsoussama.testingandroid.model

import org.junit.Assert.*
import org.junit.Test

class CityTest {

    @Test
    fun `City class should always be a data class`() {
        val city = City(name = "Adrar", country = "Algeria")
        assertTrue(city::class.isData)
    }
}