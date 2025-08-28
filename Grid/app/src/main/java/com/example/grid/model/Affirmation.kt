package com.example.grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Affirmation(
    @StringRes val stringResourceId: Int,
    val numberofCourses: Int,
    @DrawableRes val imageResourceId: Int,

)