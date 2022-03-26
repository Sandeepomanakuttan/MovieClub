package com.example.sandeep.mvvmretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sandeep.mvvmretrofit.InterFacce.MovieInterface
import com.example.sandeep.mvvmretrofit.InterFacce.idPassInterface
import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.example.sandeep.mvvmretrofit.R

class MovielistAdaptor(
    private val context: Context,
    private var movielist: List<Moviemodel>,
    val listener: MovieInterface,
    val status: String
) : RecyclerView.Adapter<MovielistAdaptor.ViewHolder>() {


    class ViewHolder(view : View):RecyclerView.ViewHolder(view) {
        val imageView= view.findViewById<ImageView>(R.id.image)!!
        val title= view.findViewById<TextView>(R.id.title)!!
    }

    fun setMovieList(movielist: List<Moviemodel>){
        this.movielist=movielist
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val view= LayoutInflater.from(parent.context).inflate(R.layout.movie_xml,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val path = "https://image.tmdb.org/t/p/w500/"
        val curentMovie = movielist[position]

            holder.title.text = curentMovie.title
            Glide.with(context).load(path + curentMovie.poster_path)
                .apply(RequestOptions.centerCropTransform()).into(holder.imageView)

            holder.itemView.setOnClickListener {
                listener.OnMovieClick(curentMovie, status)
            }
        }


    override fun getItemCount(): Int {
        return movielist.size
    }

}