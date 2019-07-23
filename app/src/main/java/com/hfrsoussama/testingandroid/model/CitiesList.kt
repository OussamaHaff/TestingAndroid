package com.hfrsoussama.testingandroid.model

object CitiesListFactory {

    fun getListOfCities() = listOf(
        City("Adrar", "Algeria"),
        City("Ilizi", "Algeria"),
        City("Sfax", "Tunisia"),
        City("London", "UK"),
        City("New York", "USA"),
        City("Tokyo", "Japan"),
        City("Rio", "Brazil")
    )
}