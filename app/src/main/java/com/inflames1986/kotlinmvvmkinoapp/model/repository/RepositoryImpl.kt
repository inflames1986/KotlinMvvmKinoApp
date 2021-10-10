package com.inflames1986.kotlinmvvmkinoapp.model.repository

import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo

class RepositoryImpl : Repository {

    override fun getFilmFromServer() = FilmInfo()

    override fun getFilmFromLocalStorage() = FilmInfo()
}