package com.naama.movieapp.filmes.presentation.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naama.movieapp.R
import com.naama.movieapp.filmes.domain.entity.Filme

class FilmeAdapter(val items:List<Filme>):RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       private val imgBasePath = "https://image.tmdb.org/t/p/w500/"
        fun bindView(filme: Filme) {

            with(itemView){
                var imgPicture= findViewById<ImageView>(R.id.imgPicture)
                Glide.with(this).load("${imgBasePath}${filme.backdropPath}").into(imgPicture)

                //atualizando o nome do Filme
                findViewById<TextView>(R.id.txtName).text = filme.name

                findViewById<ImageView>(R.id.imgFavorite).visibility = if (filme.favorite)View.VISIBLE else View.GONE
                itemView.setOnClickListener {
                    val intent = Intent(it.context,DetailActivity::class.java)
                    intent.putExtra("filme",filme)
                    it.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.serie_item,parent,false)
        return ViewHolder(view)
    }



override fun getItemCount() = items.size
override fun onBindViewHolder(holder:ViewHolder, position: Int) {
    var filme = items[position]
    holder.bindView(filme)
}
}