package com.hfrsoussama.testingandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfrsoussama.testingandroid.model.City

class MainViewModel(private val cities: List<City>) : ViewModel() {

    private val _citiesList = MutableLiveData<List<City>>()
    val citiesList: LiveData<List<City>>
        get() = _citiesList


    init {
        _citiesList.value = cities
    }

    fun searchForCityWith(string: String) {
        _citiesList.value = cities.filter {
            it.name.contains(string, ignoreCase = true)
                    || it.country.contains(string, ignoreCase = true)
        }
    }

}