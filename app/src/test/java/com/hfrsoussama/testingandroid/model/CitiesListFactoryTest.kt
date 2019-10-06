package com.hfrsoussama.testingandroid.model

import org.junit.Assert.*
import org.junit.Test

class CitiesListFactoryTest {

    private val predefinedList = listOf(
        City("Adrar", "Algeria"),
        City("Ilizi", "Algeria"),
        City("Sfax", "Tunisia"),
        City("London", "UK"),
        City("New York", "USA"),
        City("Tokyo", "Japan"),
        City("Rio", "Brazil")
    )

    @Test
    fun `Factory must return a predefined list of cities`() {
        assertEquals(predefinedList, CitiesListFactory.getListOfCities())
    }
}