package com.example.sandeep.mvvmretrofit

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.sandeep.mvvmretrofit.InterFacce.MovieInterface
import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.example.sandeep.mvvmretrofit.Model.ControlClass
import com.example.sandeep.mvvmretrofit.adapter.MovielistAdaptor
import com.example.sandeep.mvvmretrofit.adapter.SlideAdaptor
import com.example.sandeep.mvvmretrofit.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import java.util.*


class MainActivity : AppCompatActivity(),MovieInterface {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewWatch: RecyclerView
    private lateinit var recyclerViewTreand: RecyclerView
    private lateinit var NoFound: TextView
    lateinit var viewBinding: ActivityMainBinding
    lateinit var viewPager : ViewPager
    lateinit var tab_indicator: TabLayout
    lateinit var controlObj:ControlClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        val view = viewBinding.scrl
        recyclerView = view.recyclerview
        recyclerViewTreand = view.recyclerviewTd
        recyclerViewWatch = view.recyclerviewWt
        viewPager = viewBinding.viewPager
        tab_indicator=viewBinding.tabLayout
        NoFound = view.NoFound


        controlObj = ControlClass(this)


        controlObj.getUpcoming{movie : List<Moviemodel>->

            val slideAdap=SlideAdaptor(this,movie)
            viewPager.adapter = slideAdap
        }



        tab_indicator.setupWithViewPager(viewPager,true)

        val time =Timer()
        time.scheduleAtFixedRate(timers(),2000,2000)
        recyclerViewTreand.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewTreand.setHasFixedSize(true)

        controlObj.getTreadingMovieList{movie:List<Moviemodel>->
            recyclerViewTreand.adapter=MovielistAdaptor(this, movie, this, "top_rated")
        }

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.setHasFixedSize(true)
        controlObj.getMovieList{movie:List<Moviemodel>->
            recyclerView.adapter=MovielistAdaptor(this, movie, this, "popular")
        }

        recyclerViewWatch.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewWatch.setHasFixedSize(true)

        controlObj.getMLmovie{movie:List<Moviemodel>->
            recyclerViewWatch.adapter=MovielistAdaptor(this, movie, this, "malayalam")
        }
    }



          inner class timers : TimerTask() {
            override fun run() {
               this@MainActivity.runOnUiThread {
                   controlObj.getMovieList { movie: List<Moviemodel> ->
                       if (viewPager.currentItem < movie.size - 1)
                           viewPager.currentItem = viewPager.currentItem + 1
                       else
                           viewPager.currentItem = 0
                   }
               }
            }
        }

    override fun OnMovieClick(movie: Moviemodel, status: String) {
        val frag=Intial_Movie(movie,false,status)
        val FragmentManager=supportFragmentManager.beginTransaction();
        FragmentManager.replace(com.example.sandeep.mvvmretrofit.R.id.mainlayout,frag).commit()
    }

}