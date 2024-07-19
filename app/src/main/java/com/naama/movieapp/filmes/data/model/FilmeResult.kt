package com.naama.movieapp.filmes.data.model

import android.app.appsearch.SearchResults
import com.google.gson.annotations.SerializedName
import com.naama.movieapp.filmes.domain.entity.Filme

data class FilmeResult(

    val page: Int,
    //val results: List<Filme>,
    @SerializedName("results") val results: List<Filme>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_Results") val totalResults: Int

)