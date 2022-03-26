package com.example.sandeep.mvvmretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestroInstance {

    companion object{

        var retrofit:Retrofit?=null
        var retrofitM:Retrofit?=null
        val apiServices:ApiServices?=null

         fun getRetofitClient():Retrofit {

            if (retrofit==null){
                retrofit = Retrofit.Builder().
                baseUrl(Credential("").baseUri)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        fun getRetofitmovie(id: String?):Retrofit {

            val obj=Credential(id)
            if (retrofitM==null){
                retrofitM = Retrofit.Builder().
                baseUrl(obj.base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitM!!
        }

    }





    fun getMovieApi(): ApiServices? {
        return apiServices
    }
}