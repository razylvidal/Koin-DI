package com.codesthetic.devcon_koin.core.domain

/**
 * Created by razylvidal on September 28, 2023
 */
data class Artist(
    val profile: String?,
    val stageName: String?,
    val fullName: String,
    val koreanName: String,
    val koreanStageName: String?,
    val dateOfBirth: String?,
    val group: String?,
    val country: String,
    val secondCountry: String?,
    val height: String,
    val weight: String,
    val birthplace: String?,
    val otherGroup: String?,
    val formerGroup: String?,
    val gender: String,
    val position: String?,
    val instagram: String?,
    val twitter: String?,
)
