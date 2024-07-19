package com.naama.movieapp.filmes.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naama.movieapp.filmes.domain.entity.Filme
import com.naama.movieapp.filmes.domain.entity.usecase.FilmeUseCase

class MainViewModel(application:Application): ViewModel(){

    private val useCase= FilmeUseCase(application)
    var filme = MutableLiveData<List<Filme>>()

    fun load(){
        Thread(Runnable {
          useCase.get()
            filme.postValue(useCase.get())
        }).start()


    }

}