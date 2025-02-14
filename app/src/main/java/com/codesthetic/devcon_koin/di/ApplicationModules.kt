package com.codesthetic.devcon_koin.di

import com.codesthetic.devcon_koin.core.data.ArtistAPI
import com.codesthetic.devcon_koin.core.data.ArtistRepository
import com.codesthetic.devcon_koin.core.domain.ArtistGateway
import com.codesthetic.devcon_koin.core.domain.FetchArtistUseCase
import com.codesthetic.devcon_koin.helper.Constants.BASE_URL
import com.codesthetic.devcon_koin.ui.ArtistViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by razylvidal on September 28, 2023
 */

val artistModule = module {

    single<ArtistGateway> { ArtistRepository(get()) }

    single { FetchArtistUseCase(get()) }

}

val httpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("X-RapidAPI-Key", "15d26384c0msh6edb539b62fc1dep14227ajsn203c28fdd24a")
            .header("X-RapidAPI-Host", "k-pop.p.rapidapi.com")
            .build()
        chain.proceed(modifiedRequest)
    }
    .build()

val retrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ArtistAPI> {
        get<Retrofit>().create(ArtistAPI::class.java)
    }
}



val presenter = module {
    viewModel {
        ArtistViewModel(get())
    }
}

val combinedModules = listOf(artistModule, retrofitModule, presenter)
