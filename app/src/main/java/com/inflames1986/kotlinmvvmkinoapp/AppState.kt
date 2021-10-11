package com.inflames1986.kotlinmvvmkinoapp

import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo

sealed class AppState {

    data class Success(val filmData: List<FilmInfo>) : AppState()
    data class Error(val Error: Throwable) : AppState()
    object Loading : AppState()

}
