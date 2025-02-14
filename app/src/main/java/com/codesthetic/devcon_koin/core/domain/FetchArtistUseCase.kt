package com.codesthetic.devcon_koin.core.domain

/**
 * Created by razylvidal on September 28, 2023
 */
interface UseCase<in Params, out Result> {
    suspend fun execute(params: Params): Result
}

class FetchArtistUseCase(
    private val gateway: ArtistGateway
) : UseCase<Unit, FetchArtistUseCase.Result> {

    data class Result(val artist: Artist)

    override suspend fun execute(params: Unit): Result {
        return Result(gateway.fetch())
    }
}
