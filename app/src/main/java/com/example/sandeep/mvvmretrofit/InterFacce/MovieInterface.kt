package com.example.sandeep.mvvmretrofit.InterFacce

import com.example.sandeep.mvvmretrofit.Model.Moviemodel

interface MovieInterface {

    fun OnMovieClick(movie: Moviemodel, status: String)

}