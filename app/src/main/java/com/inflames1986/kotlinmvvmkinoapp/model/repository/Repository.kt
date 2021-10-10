package com.inflames1986.kotlinmvvmkinoapp.model.repository

import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo

interface Repository {

    fun getFilmFromServer(): FilmInfo
    fun getFilmFromLocalStorage(): FilmInfo
}