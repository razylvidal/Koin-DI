package com.codesthetic.devcon_koin.core.data

import com.google.gson.annotations.SerializedName

/**
 * Created by razylvidal on September 28, 2023
 */
data class ArtistResult(

    @SerializedName("data")
    val artists : List<ArtistRaw>
)
