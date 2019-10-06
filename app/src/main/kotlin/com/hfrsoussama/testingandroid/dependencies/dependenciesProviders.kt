package com.hfrsoussama.testingandroid.dependencies

import com.hfrsoussama.testingandroid.model.CitiesListFactory
import com.hfrsoussama.testingandroid.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repoModule = module {
    single { CitiesListFactory.getListOfCities() }
}

val viewModelsModule = module {
    viewModel { MainViewModel(cities = get()) }
}
