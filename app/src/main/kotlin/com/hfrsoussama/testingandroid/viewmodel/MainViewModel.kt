package com.hfrsoussama.testingandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfrsoussama.testingandroid.model.CitiesListFactory
import com.hfrsoussama.testingandroid.model.City

class MainViewModel : ViewModel() {

    val citiesList  by lazy { MutableLiveData<List<City>>() }

    init {
        citiesList.value = CitiesListFactory.getListOfCities()
    }

    /**
     * 
     *
     * Resolves :
     * - RG-
     * - RG-
     *
     * @see <a href="">RG-</a>
     */
    fun searchForCityWith(string: String) {
        citiesList.value = CitiesListFactory.getListOfCities()
            .filter { it.name.contains(string, ignoreCase = true) || it.country.contains(string, ignoreCase = true) }
    }

}