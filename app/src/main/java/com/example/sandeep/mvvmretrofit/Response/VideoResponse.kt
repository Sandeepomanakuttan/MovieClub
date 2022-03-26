package com.example.sandeep.mvvmretrofit.Response

import android.os.Parcelable
import com.example.sandeep.mvvmretrofit.Model.VideoModel
import com.google.gson.annotations.SerializedName
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
data class VideoResponse(
    @SerializedName("results")
    var video:List<VideoModel>
): Parcelable {
    constructor():this(mutableListOf())
}
