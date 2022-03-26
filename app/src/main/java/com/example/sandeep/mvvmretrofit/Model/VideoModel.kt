package com.example.sandeep.mvvmretrofit.Model

import com.google.gson.annotations.SerializedName
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
data class VideoModel (

    @SerializedName("key")
    var key:String?,
    @SerializedName("id")
    var id:String?,
):Parcelable{
    constructor():this("","")
}