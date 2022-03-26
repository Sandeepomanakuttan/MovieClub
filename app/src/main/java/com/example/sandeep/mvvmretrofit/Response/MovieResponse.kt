package com.example.sandeep.mvvmretrofit.Response

import android.os.Parcel
import android.os.Parcelable
import com.example.sandeep.mvvmretrofit.Model.Moviemodel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//single movie request
@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movie : List<Moviemodel>
):Parcelable {
    //1.finding movie obj
    constructor() : this(mutableListOf()) {
    }



}