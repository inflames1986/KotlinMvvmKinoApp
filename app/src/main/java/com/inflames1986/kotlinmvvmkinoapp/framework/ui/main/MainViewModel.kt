package com.inflames1986.kotlinmvvmkinoapp.framework.ui.main

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inflames1986.kotlinmvvmkinoapp.AppState
import com.inflames1986.kotlinmvvmkinoapp.model.repository.Repository
import java.lang.Thread.sleep

class MainViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {
    private val liveData = MutableLiveData<AppState>()

    fun getLiveData(): LiveData<AppState> = liveData

    fun getFilm() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveData.value = AppState.Loading
        Thread {
            sleep(1000)
            liveData.postValue(AppState.Success(repository.getFilmFromLocalStorage()))
        }.start()
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    private fun onViewStart() {
//        Log.i("LifecycleEvent", "onStart")
//    }
}