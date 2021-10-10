package com.inflames1986.kotlinmvvmkinoapp.model.repository

import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo
import com.inflames1986.kotlinmvvmkinoapp.model.entities.getRussianFilms
import com.inflames1986.kotlinmvvmkinoapp.model.entities.getWorldFilms

class RepositoryImpl : Repository {

    override fun getFilmFromServer() = FilmInfo()
    override fun getFilmFromLocalStorageRus() = getRussianFilms()
    override fun getFilmFromLocalStorageWorld() = getWorldFilms()
}