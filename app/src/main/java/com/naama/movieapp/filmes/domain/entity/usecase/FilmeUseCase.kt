package com.naama.movieapp.filmes.domain.entity.usecase

import android.app.Application
import com.naama.movieapp.filmes.data.repository.FilmeApiRepository
import com.naama.movieapp.filmes.data.repository.FilmeSqlLiteRepository
import com.naama.movieapp.filmes.domain.entity.Filme

class FilmeUseCase(application: Application) {
    private val apiRepository = FilmeApiRepository
    private val dbRepository = FilmeSqlLiteRepository(application)

    fun get(): List<Filme>{
        var filmes : List<Filme> = listOf()
        dbRepository.get()?.let {
            filmes = filmes.plus(it)
        }

        apiRepository.get()?.let {
            var lista = it.toMutableList()
            lista.removeAll { filme  ->  filmes.any {filmeDb -> filmeDb.id ==filme.id } }
            filmes = filmes.plus(lista)
        }
        return filmes
    }

    fun favorite(filme: Filme){
        filme.favorite = true
        dbRepository.add(filme)

    }
    fun unfavorite(filme: Filme){

        dbRepository.delete(filme)
    }
}