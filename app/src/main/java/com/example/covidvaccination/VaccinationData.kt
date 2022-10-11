package com.example.covidvaccination

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class VaccinationData(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageId: Int
)


