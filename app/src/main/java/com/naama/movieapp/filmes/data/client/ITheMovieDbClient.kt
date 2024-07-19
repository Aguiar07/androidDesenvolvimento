package com.naama.movieapp.filmes.data.client

import android.telecom.Call
import com.naama.movieapp.filmes.data.model.FilmeResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ITheMovieDbClient {
    @GET("3/movie/popular")
    fun getMoviePopular(@Query("api_key")apikey: String):retrofit2.Call<FilmeResult>

}