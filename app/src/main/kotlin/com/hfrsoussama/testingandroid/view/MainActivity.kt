package com.hfrsoussama.testingandroid.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfrsoussama.testingandroid.R
import com.hfrsoussama.testingandroid.model.City
import com.hfrsoussama.testingandroid.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val observer = Observer<List<City>> { render(it) }

    private fun render(citiesList: List<City>) {
        citiesRecyclerView.swapAdapter(CitiesAdapter(citiesList), false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CitiesAdapter(viewModel.citiesList.value.orEmpty())
        }

        viewModel.citiesList.observe(this, observer)

        btnSearch.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btnSearch -> viewModel.searchForCityWith(etSearchInput.text.toString())
        }
    }
}
