package com.hfrsoussama.testingandroid.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.hfrsoussama.testingandroid.dependencies.appModules
import com.hfrsoussama.testingandroid.model.City
import org.junit.*
import org.junit.Assert.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import kotlin.random.Random

class MainViewModelTest : KoinTest {

    private val mainViewModel: MainViewModel by inject()
    private val citiesRepo : List<City> by inject()

    @Mock
    lateinit var uiObserver : Observer<List<City>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin { modules(appModules) }
        mainViewModel.citiesFilteredList.observeForever(uiObserver)
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `When ViewModel is created, it has the full list of cities`() {
        val viewModelCities = mainViewModel.citiesFilteredList.value.orEmpty()

        assertEquals(citiesRepo.size, viewModelCities.size).also {
            verify(uiObserver).onChanged(viewModelCities)
        }
    }

    @Test
    fun `When searching with empty string, all cities are returned`() {
        mainViewModel.searchForCityWith("")
        val filteredCities = mainViewModel.citiesFilteredList.value.orEmpty()

        assertEquals(citiesRepo.size, filteredCities.size).also {
            verify(uiObserver, atMost(2)).onChanged(filteredCities)
        }
    }

    @Test
    fun `When searching using a number, a void list is returned` () {
        val randomInt  = Random.nextInt()
        mainViewModel.searchForCityWith(randomInt.toString())
        val filteredCities = mainViewModel.citiesFilteredList.value.orEmpty()

        assertTrue(filteredCities.isEmpty()).also {
            verify(uiObserver, atMost(2)).onChanged(filteredCities)
        }
    }

    @Test
    fun `When searching city name using a small case or upper case, same result is returned` () {
        mainViewModel.searchForCityWith("adrar")
        val resultOfUpperSmallSearch = mainViewModel.citiesFilteredList.value.orEmpty()
        mainViewModel.searchForCityWith("Adrar")
        val resultOfUpperCaseSearch = mainViewModel.citiesFilteredList.value.orEmpty()
        assertEquals(resultOfUpperCaseSearch, resultOfUpperSmallSearch)
    }

    @Test
    fun `When searching city country using a small case or upper case, same result is returned` () {
        mainViewModel.searchForCityWith("algeria")
        val resultOfUpperSmallSearch = mainViewModel.citiesFilteredList.value.orEmpty()
        mainViewModel.searchForCityWith("Algeria")
        val resultOfUpperCaseSearch = mainViewModel.citiesFilteredList.value.orEmpty()
        assertEquals(resultOfUpperCaseSearch, resultOfUpperSmallSearch)
    }




}