package com.naama.movieapp.filmes.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.naama.movieapp.filmes.domain.entity.Filme
import com.naama.movieapp.filmes.domain.entity.usecase.FilmeUseCase

class DetailViewModel(application: Application):ViewModel() {

    private val useCase= FilmeUseCase(application)

    fun favorite(filme: Filme){

        useCase.favorite(filme)

    }
    fun unfavorite(filme: Filme){
        useCase.unfavorite(filme)
    }
}