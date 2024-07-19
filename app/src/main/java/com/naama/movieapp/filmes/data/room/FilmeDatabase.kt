package com.naama.movieapp.filmes.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.naama.movieapp.filmes.domain.entity.Filme


@Database(version = 1, entities = [Filme::class])
abstract class FilmeDatabase:RoomDatabase() {

    abstract fun filmeDao():IFilmeDao


}