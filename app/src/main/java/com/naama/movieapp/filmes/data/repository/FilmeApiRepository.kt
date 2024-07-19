package com.naama.movieapp.filmes.data.repository

import android.util.Log
import com.naama.movieapp.filmes.data.client.ITheMovieDbClient
import com.naama.movieapp.filmes.domain.entity.Filme
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object FilmeApiRepository {

    private val theMovieDbClient: ITheMovieDbClient
    private val apikey = "93544b8e5adcb5ee6386d6c46d21003c"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()



        theMovieDbClient = retrofit.create(ITheMovieDbClient::class.java)
    }

    fun get(): List<Filme>? {
     try {
         val call = theMovieDbClient.getMoviePopular(apikey)
         return call.execute().body()?.results
     }catch (e: Exception){
         Log.e("MovieApiRepository", e.message.toString())
         return null
     }
    }
}


