package com.inflames1986.kotlinmvvmkinoapp.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class FilmInfo(

    val film_title: Film = getDefaultFilm(),
    val film_year: Int = 2009,
    val film_budget: Int = 100000
): Parcelable

fun getDefaultFilm() = Film("Avatar", "fantasy", 4.9)

fun getWorldFilms() = listOf(
    FilmInfo(Film("Зеленая миля", "драма", 8.9), 1999, 60000000),
    FilmInfo(Film("Побег из шоушенка", "драма", 8.9), 1994, 25000000),
    FilmInfo(Film("Властелин колец: Возвращение короля", "фэнтази", 8.8), 2003, 94000000),
    FilmInfo(Film("Властелин колец: Две крепости", "фэнтази", 8.8), 2002, 94000000),
    FilmInfo(Film("Властелин колец: Братство кольца", "фэнтази", 8.8), 2001, 93000000),
    FilmInfo(Film("Форест Гамп", "драма", 8.6), 1994, 55000000),
    FilmInfo(Film("Интерстеллар", "фантастика", 8.6), 2014, 165000000),
    FilmInfo(Film("Криминальное чтиво", "криминал, драма", 8.6), 1994, 8000000),
    FilmInfo(Film("Матрица", "фантастика", 8.6), 1999, 63000000),
    FilmInfo(Film("Начало", "фантастика", 8.6), 2010, 160000000)
)

fun getRussianFilms() = listOf(
    FilmInfo(Film("Брат", "драма", 8.2), 1997, 12451240),
    FilmInfo(Film("Брат2", "драма", 8.1), 2000, 26000000),
    FilmInfo(Film("Огонь", "драма", 7.7), 2020, 14000000),
    FilmInfo(Film("Балканский рубеж", "военный", 7.4), 2019, 15000000),
    FilmInfo(Film("Жмурки", "комедия", 7.1), 2005, 33000000),
    FilmInfo(Film("Конек - горбунок", "фэнтази", 6.9), 2021, 45000000),
    FilmInfo(Film("Битва за Севастополь", "военный", 7.5), 2015, 35000000),
    FilmInfo(Film("Притяжение", "фантастика", 5.6), 2017, 8600000),
    FilmInfo(Film("9 рота", "военный", 6.7), 2005, 62000000),
    FilmInfo(Film("Экипаж", "драма", 7.6), 2016, 45000000)
)
