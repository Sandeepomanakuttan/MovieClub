package com.example.sandeep.mvvmretrofit.Response

import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//geting multiple movies
class MovieSearchResponse {

    @SerializedName("results")
    @Expose()
    var movies:List<Moviemodel>?=null

    @JvmName("getMovies1")
    fun getMovies():List<Moviemodel>{
        return movies!!
    }

    override fun toString(): String {
        return "MovieSearchResponse(movies=$movies)"
    }


}