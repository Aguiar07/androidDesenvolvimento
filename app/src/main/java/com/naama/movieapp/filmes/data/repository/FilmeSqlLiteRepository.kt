package com.naama.movieapp.filmes.data.repository

import android.app.Application
import androidx.room.Room
import com.naama.movieapp.filmes.data.room.FilmeDatabase
import com.naama.movieapp.filmes.domain.entity.Filme

class FilmeSqlLiteRepository (application: Application){

    companion object{
        var database: FilmeDatabase? = null
    }

    init {
        database = Room.databaseBuilder(application,FilmeDatabase::class.java, "filme-db")

            .allowMainThreadQueries()
            .build()

    }
    fun add(filme: Filme){

        database?.filmeDao()?.insert(filme)
    }
    fun delete(filme: Filme){

        database?.filmeDao()?.delete(filme)
    }
    fun get(): List<Filme>{

       return database?.filmeDao()?.get()!!
    }


}