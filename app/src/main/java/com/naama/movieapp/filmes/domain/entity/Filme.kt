package com.naama.movieapp.filmes.domain.entity

import androidx.room.ColumnInfo
import java.io.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "filme")
data class Filme(
    @PrimaryKey val id:Int,
    val name: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo("backdrop_path") @SerializedName("backdrop_path") val backdropPath:String,
    @ColumnInfo("poster_path") @SerializedName("poster_path")  val posterpath: String,
    val adult:Boolean,
    var favorite:Boolean

): Serializable