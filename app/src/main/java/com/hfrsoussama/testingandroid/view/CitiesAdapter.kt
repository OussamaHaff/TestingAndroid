package com.hfrsoussama.testingandroid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfrsoussama.testingandroid.R
import com.hfrsoussama.testingandroid.model.City
import kotlinx.android.synthetic.main.item_city.view.*

class CitiesAdapter(private val citiesData: List<City>) : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = citiesData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCity(citiesData[position])
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindCity(city: City) {
            view.apply {
                txCityName.text = city.name
                txCityCountry.text = city.country
            }
        }
    }
}
