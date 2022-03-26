package com.example.sandeep.mvvmretrofit.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.example.sandeep.mvvmretrofit.network.ApiServices
import com.example.sandeep.mvvmretrofit.network.RestroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class movieListviewModel() : ViewModel() {

    lateinit var movielist:MutableLiveData<List<Moviemodel>>
    init {
            movielist= MutableLiveData()
    }

    fun getMovielistObserved():MutableLiveData<List<Moviemodel>> {

        return movielist
    }


}