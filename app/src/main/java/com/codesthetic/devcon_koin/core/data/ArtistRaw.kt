package com.codesthetic.devcon_koin.core.data

import com.google.gson.annotations.SerializedName

/**
 * Created by razylvidal on September 28, 2023
 */
data class ArtistRaw(

    @SerializedName("Profile")
    val profile : String?,

    @SerializedName("Stage Name")
    val stageName : String?,

    @SerializedName("Full Name")
    val fullName : String,

    @SerializedName("Korean Name")
    val koreanName : String,

    @SerializedName("K. Stage Name")
    val koreanStageName : String?,

    @SerializedName("Date of Birth")
    val dateOfBirth : String?,

    @SerializedName("Group")
    val group : String?,

    @SerializedName("Country")
    val country : String,

    @SerializedName("Second Country")
    val secondCountry : String?,

    @SerializedName("Height")
    val height : String,

    @SerializedName("Weight")
    val weight : String,

    @SerializedName("Birthplace")
    val birthplace : String,

    @SerializedName("Other Group")
    val otherGroup : String?,

    @SerializedName("Former Group")
    val formerGroup : String?,

    @SerializedName("Gender")
    val gender : String,

    @SerializedName("Position")
    val position : String?,

    @SerializedName("Instagram")
    val instagram : String?,

    @SerializedName("Twitter")
    val twitter : String?,
)
