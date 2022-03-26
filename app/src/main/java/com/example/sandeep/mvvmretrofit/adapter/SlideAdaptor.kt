package com.example.sandeep.mvvmretrofit.adapter

import android.content.Context
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.example.sandeep.mvvmretrofit.R
import com.example.sandeep.mvvmretrofit.network.Credential
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class SlideAdaptor(private val context: Context, private val list: List<Moviemodel>) : PagerAdapter() {
        lateinit var nameArray : ArrayList<String>
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val view =layoutInflater!!.inflate(R.layout.slider, container, false)
        nameArray= arrayListOf()
        val title = view.findViewById<TextView>(R.id.title)
        val imageview = view.findViewById<ImageView>(R.id.imageview)

        val path = "https://image.tmdb.org/t/p/w500/"

        val m=list[position]
        Glide.with(context).load(path + m.poster_path)
            .apply(RequestOptions.centerCropTransform()).into(imageview)
        //Glide.with(context).load(path+list[position].poster_path).into(imageview)
        title.text=m.title
        container.addView(view)
       return view

    }

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }


    override fun destroyItem(container: ViewGroup, position: Int,`object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}