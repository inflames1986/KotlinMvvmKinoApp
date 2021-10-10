package com.inflames1986.kotlinmvvmkinoapp.di

import com.inflames1986.kotlinmvvmkinoapp.framework.ui.main.MainViewModel
import com.inflames1986.kotlinmvvmkinoapp.model.repository.Repository
import com.inflames1986.kotlinmvvmkinoapp.model.repository.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Repository> { RepositoryImpl() }
    //view models
    viewModel { MainViewModel(get()) }
}