package com.example.sandeep.mvvmretrofit.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Moviemodel(
    @SerializedName("id")
    val id : String?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("title")
    val title:String?,

    @SerializedName("poster_path")
    var poster_path:String,

    @SerializedName("release_date")
    var release_date:String?,

    @SerializedName("movie_id")
    var movie_id:Int?,

    @SerializedName("vote_average")
    var vote_average:Float?,

    @SerializedName("overview")
    var overview:String?

    ):Parcelable{
    constructor(): this("","","","","",0, Float.MAX_VALUE,"")
}
