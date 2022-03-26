package com.example.sandeep.mvvmretrofit.network

import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.example.sandeep.mvvmretrofit.Response.MovieResponse
import com.example.sandeep.mvvmretrofit.Response.VideoResponse
import retrofit2.http.GET
import retrofit2.Call

interface ApiServices {
    var id:String
    @GET("/3/movie/top_rated?api_key=7acfe3116e0290cdc98f8fa1ff4519f0")
    fun getTreadingMovieList() : Call<MovieResponse>
    @GET("/3/movie/popular?api_key=7acfe3116e0290cdc98f8fa1ff4519f0")
    fun getPopularMovie() : Call<MovieResponse>
    @GET("/3/discover/movie?api_key=7acfe3116e0290cdc98f8fa1ff4519f0&language=ml-IN&region=IN&release_date.gte=2016-11-16&release_date.lte=2016-12-02&with_release_type=2|3")
    fun getMalayalamMovie():Call<MovieResponse>
    @GET("videos?api_key=7acfe3116e0290cdc98f8fa1ff4519f0")
    fun getMovieTrailer():Call<VideoResponse>
    @GET("/3/movie/upcoming?api_key=7acfe3116e0290cdc98f8fa1ff4519f0")
    fun getUpcomingMovie(): Call<MovieResponse>
}

