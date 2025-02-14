package com.codesthetic.devcon_koin.core.data

import retrofit2.http.GET

/**
 * Created by razylvidal on September 28, 2023
 */
interface ArtistAPI {

    @GET("/idols/random")
    suspend fun fetch() : ArtistResult

}
