package com.inflames1986.kotlinmvvmkinoapp.model.repository

import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo

interface Repository {

    fun getFilmFromServer(): FilmInfo
    fun getFilmFromLocalStorageRus(): List<FilmInfo>
    fun getFilmFromLocalStorageWorld(): List<FilmInfo>
}