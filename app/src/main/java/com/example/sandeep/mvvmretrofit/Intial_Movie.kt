package com.example.sandeep.mvvmretrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sandeep.mvvmretrofit.InterFacce.MovieInterface
import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.example.sandeep.mvvmretrofit.Model.VideoModel
import com.example.sandeep.mvvmretrofit.Model.ControlClass
import com.example.sandeep.mvvmretrofit.adapter.MovielistAdaptor
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class Intial_Movie(val movie: Moviemodel, enabled: Boolean, val status: String) : Fragment(),
    MovieInterface {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intial__movie, container, false)

        val video = view.findViewById<YouTubePlayerView>(R.id.mainImg)
        val subimage = view.findViewById<ImageView>(R.id.imageView4)
        val realese_date = view.findViewById<TextView>(R.id.realese_date)
        val rating = view.findViewById<TextView>(R.id.rating)
        val overview = view.findViewById<TextView>(R.id.overview)
        val name = view.findViewById<TextView>(R.id.name)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val path = "https://image.tmdb.org/t/p/w500/"
        val obj=ControlClass(requireContext())

        lifecycle.addObserver(video)


        obj.getTrailer(movie.id.toString()){ videos:List<VideoModel>->

            video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    Log.e("Tag.................",movie.id.toString())
                    val videoId = videos[0].key
                    youTubePlayer.loadVideo(videoId.toString(),0f)
                    youTubePlayer.play()
                   // youTubePlayer.cueVideo(videoId!!, 0f)
                }
            })


        }


        //Glide.with(this).load(path+movie.poster_path).into(image)
        Glide.with(this).load(path + movie.poster_path).apply(RequestOptions.centerCropTransform())
            .into(subimage)

        name.text = movie.title
        realese_date.text = movie.release_date
        rating.text = movie.vote_average.toString()
        overview.text = movie.overview

        recycler.setHasFixedSize(true)
        recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intent = Intent(activity!!.applicationContext, MainActivity::class.java)
                startActivity(intent)
                activity!!.finish()
            }
        })


        when (status) {
            "top_rated" -> {
                obj.getTreadingMovieList { movies: List<Moviemodel> ->

                    val collection = ArrayList<Moviemodel>()
                    for (m in movies) {
                        if (m.id != movie.id) {
                            collection.add(m)
                        }
                    }
                    recycler.adapter =
                        MovielistAdaptor(requireContext(), collection, this, status)
                }
            }
            "popular" -> {

                obj.getMovieList { movies: List<Moviemodel> ->
                    var collection = ArrayList<Moviemodel>()

                    for (m in movies) {
                        if (m.id != movie.id) {
                            collection.add(m)
                        }
                    }

                    recycler.adapter = MovielistAdaptor(requireContext(), collection, this, status)
                }
            }
            else -> {

                obj.getMLmovie { movies: List<Moviemodel> ->
                    var collection = ArrayList<Moviemodel>()

                    for (m in movies) {
                        if (m.id != movie.id) {
                            collection.add(m)
                        }
                    }

                    recycler.adapter = MovielistAdaptor(requireContext(), collection, this, status)
                }
            }
        }
        return view
    }

    override fun OnMovieClick(movie: Moviemodel, status: String) {
        val frag = Intial_Movie(movie, false, status)
        val FragmentManager = requireFragmentManager().beginTransaction()
        FragmentManager.replace(com.example.sandeep.mvvmretrofit.R.id.mainlayout, frag).commit()
    }


}