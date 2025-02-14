package com.codesthetic.devcon_koin.core.data

import com.codesthetic.devcon_koin.core.domain.Artist

/**
 * Created by razylvidal on September 28, 2023
 */

fun ArtistRaw.toDomain() = Artist(
    profile,
    stageName,
    fullName,
    koreanName,
    koreanStageName,
    dateOfBirth,
    group,
    country,
    secondCountry,
    height,
    weight,
    birthplace,
    otherGroup,
    formerGroup,
    gender,
    position,
    instagram,
    twitter
)
