package com.example.covidvaccination

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//creating list item data class
class dataSource(){

    fun loadData(): List<VaccinationData> {
        return listOf<VaccinationData>(
            VaccinationData(R.string.country1_description,R.drawable.download),
            VaccinationData(R.string.country2_description,R.drawable.download__2_),
            VaccinationData(R.string.country3_description,R.drawable.download__1_),
            VaccinationData(R.string.country4_description,R.drawable.images)
        )
    }
}
//The loadData() method gathers all of the data and returns it as a list.