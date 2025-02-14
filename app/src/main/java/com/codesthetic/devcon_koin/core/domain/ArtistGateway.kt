package com.codesthetic.devcon_koin.core.domain

/**
 * Created by razylvidal on September 28, 2023
 */
interface ArtistGateway {

    suspend fun fetch() : Artist
}
