package com.example.sandeep.mvvmretrofit.Model

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.sandeep.mvvmretrofit.Response.MovieResponse
import com.example.sandeep.mvvmretrofit.Response.VideoResponse
import com.example.sandeep.mvvmretrofit.network.ApiServices
import com.example.sandeep.mvvmretrofit.network.Credential
import com.example.sandeep.mvvmretrofit.network.RestroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class ControlClass(val context: Context) {
    lateinit var id:String
    fun getMLmovie(callback: (List<Moviemodel>) -> Unit) {

        val api = RestroInstance.getRetofitClient().create(ApiServices::class.java)
        with(api) {
            getMalayalamMovie().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {

                    return callback(response.body()!!.movie)

                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                }
            })
        }

    }

//    private fun getMainMovie(callback: (List<Moviemodel>) -> Unit) {
//        val apiServices = RestroInstance.getRetofitClient().create(ApiServices::class.java)
//        apiServices.getMovieTrailer().enqueue(object : Callback<MovieResponse> {
//            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//
//                return callback(response.body()!!.movie)
//            }
//
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//            }
//        })
//    }

    fun getTreadingMovieList(callback: (List<Moviemodel>) -> Unit) {

        val apiServices = RestroInstance.getRetofitClient().create(ApiServices::class.java)
        apiServices.getTreadingMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movie)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getMovieList(callback: (List<Moviemodel>) -> Unit) {

        val apiServices = RestroInstance.getRetofitClient().create(ApiServices::class.java)
        apiServices.getPopularMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                return callback(response.body()!!.movie)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getUpcoming(callback: (List<Moviemodel>) -> Unit) {
        val apiServices = RestroInstance.getRetofitClient().create(ApiServices::class.java)
        apiServices.getUpcomingMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                return callback(response.body()!!.movie)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    fun getTrailer(id: String, callback: (List<VideoModel>) -> Unit) {

        this.id=id
        
        val apiServices=RestroInstance.getRetofitmovie(id).create(ApiServices::class.java)
        apiServices.getMovieTrailer().enqueue(object :Callback<VideoResponse>{
            override fun onResponse(call: Call<VideoResponse>, response: Response<VideoResponse>) {
                return callback(response.body()!!.video)
            }

            override fun onFailure(call: Call<VideoResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }



}


