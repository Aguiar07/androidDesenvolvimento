package com.naama.movieapp.filmes.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.naama.movieapp.filmes.domain.entity.Filme

@Dao

interface IFilmeDao {
    @Query("SELECT *FROM filme")
    fun get():List<Filme>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg filme: Filme)

    @Delete
    fun delete(filme: Filme)
}