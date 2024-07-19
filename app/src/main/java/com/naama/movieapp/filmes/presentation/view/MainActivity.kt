package com.naama.movieapp.filmes.presentation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.naama.movieapp.R
import com.naama.movieapp.filmes.data.repository.FilmeApiRepository
import com.naama.movieapp.filmes.domain.entity.Filme
import com.naama.movieapp.filmes.presentation.viewmodel.FilmeViewModelFactory
import com.naama.movieapp.filmes.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    //private var filmes: List<Filme> = listOf()
    val viewModel by lazy {
        var factory = FilmeViewModelFactory(application)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rcvFilmes)
        viewModel.filme.observe(this){
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter =FilmeAdapter(it)

        }

       // Thread(Runnable {
        //    FilmeApiRepository.get()?.let {
         //       filmes = it
         //   }
         //   recyclerView.post{
         //       loadRecycleView()}
        //}).start()
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }

}