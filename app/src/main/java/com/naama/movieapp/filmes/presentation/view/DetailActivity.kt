package com.naama.movieapp.filmes.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.naama.movieapp.R
import com.naama.movieapp.filmes.domain.entity.Filme
import com.naama.movieapp.filmes.presentation.viewmodel.DetailViewModel
import com.naama.movieapp.filmes.presentation.viewmodel.FilmeViewModelFactory
import com.naama.movieapp.filmes.presentation.viewmodel.MainViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var txtTitle: TextView
    private lateinit var txtDescription: TextView
    private lateinit var imgBack: ImageView
    private lateinit var imgPoster: ImageView
    private lateinit var btnFavorite: Button
    private val imgBasePath = "https://image.tmdb.org/t/p/w500/"


    private var filme: Filme? = null

    val viewModel by lazy {
        var factory = FilmeViewModelFactory(application)
        ViewModelProvider(this, factory)[DetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        filme = intent.getSerializableExtra("filme") as Filme
        bindView()

    }

    fun bindView() {
        txtTitle = findViewById(R.id.txtDetailName)
        txtDescription = findViewById(R.id.txtDetailDescription)
        imgBack = findViewById(R.id.imgDetailBack)
        imgPoster = findViewById(R.id.imgDetailPoster)
        btnFavorite = findViewById(R.id.btnDetailFavorite)

        filme?.let {
            txtTitle.text = it.name
            txtDescription.text = it.overview

            Glide.with(this).load("${imgBasePath}${filme!!.backdropPath}").into(imgBack)
            Glide.with(this).load("${imgBasePath}${filme!!.posterpath}").into(imgPoster)

            btnFavorite.text= if(filme!!.favorite) {
                "Desfavoritar"
            } else "Favoritar"
            btnFavorite.setOnClickListener {
                if (filme!!.favorite)
                unfavorite(filme!!)
                else
                    favorite(filme!!)
                    finish()
            }
        }

    }

    private fun unfavorite(filme: Filme) {
viewModel.unfavorite(filme)
    }
    private fun favorite(filme: Filme) {
viewModel.favorite(filme)
    }
}