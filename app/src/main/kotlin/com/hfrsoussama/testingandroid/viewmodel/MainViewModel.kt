package com.hfrsoussama.testingandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfrsoussama.testingandroid.model.City

class MainViewModel(private val allCities: List<City>) : ViewModel() {

    private val _filteredListOfCities = MutableLiveData<List<City>>()
    val citiesFilteredList: LiveData<List<City>>
        get() = _filteredListOfCities


    init {
        _filteredListOfCities.value = allCities
    }

    fun searchForCityWith(string: String) {
        _filteredListOfCities.value = allCities.filter {
            it.name.contains(string, ignoreCase = true)
                    || it.country.contains(string, ignoreCase = true)
        }
    }

}