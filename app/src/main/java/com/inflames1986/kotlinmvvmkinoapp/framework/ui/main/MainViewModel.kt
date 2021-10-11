package com.inflames1986.kotlinmvvmkinoapp.framework.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.inflames1986.kotlinmvvmkinoapp.AppState
import com.inflames1986.kotlinmvvmkinoapp.model.repository.Repository
import java.lang.Thread.sleep

class MainViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {
    private val liveData = MutableLiveData<AppState>()

    fun getLiveData(): LiveData<AppState> = liveData

    fun getFilmFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)

    fun getFilmFromLocalSourceWorld() = getDataFromLocalSource(isRussian = false)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveData.value = AppState.Loading
        Thread {
            sleep(1000)
            liveData.postValue(
                if (isRussian) {
                    AppState.Success(repository.getFilmFromLocalStorageRus())
                } else {
                    AppState.Success(repository.getFilmFromLocalStorageWorld())
                }
            )
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onViewStart() {
        Log.i("LifecycleEvent", "onStart")
    }
}