package com.codesthetic.devcon_koin.core.data

import android.util.Log
import com.codesthetic.devcon_koin.core.domain.Artist
import com.codesthetic.devcon_koin.core.domain.ArtistGateway

/**
 * Created by razylvidal on September 28, 2023
 */
class ArtistRepository(
    private val api : ArtistAPI
) : ArtistGateway {

    override suspend fun fetch(): Artist {
        val response = api.fetch().artists.map {
            it.toDomain()
        }
        Log.e("response", response.toString())
        return response[0]

    }
}
