package com.inflames1986.kotlinmvvmkinoapp.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Film(

    val film: String,
    val genre: String,
    val imdb: Double
): Parcelable
