package com.inflames1986.kotlinmvvmkinoapp.model.entities

data class FilmInfo(
    val film_title: Film = getDefaultFilm(),
    val film_year: Int = 2009,
    val film_budget: Int = 100000
)

fun getDefaultFilm() = Film("Avatar", "fantasy", 4.9)