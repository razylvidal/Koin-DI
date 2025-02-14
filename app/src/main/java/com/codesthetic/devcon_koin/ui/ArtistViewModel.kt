package com.codesthetic.devcon_koin.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.codesthetic.devcon_koin.core.domain.Artist
import com.codesthetic.devcon_koin.core.domain.FetchArtistUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * Created by razylvidal on September 28, 2023
 */
class ArtistViewModel(
    private val fetchArtistUseCase: FetchArtistUseCase
) : ArtistContract.Presenter , ViewModel(){

    private var view: ArtistContract.View? = null

    private var scope = MainScope()

    override fun onViewReady(view: ArtistContract.View) {
        this.view = view
        onRandomize()
    }

    override fun onRandomize() {
        view?.showLoadingDialog(true)
        scope.launch {
            try {
                val artist = fetchArtistUseCase.execute(Unit).artist
                view?.displayArtist(artist)
            } catch (ex: Exception) {
                view?.showToast(ex.toString())
                Log.e("EXCEPTION", ex.toString())
            }
        }
        view?.showLoadingDialog(false)
    }

    override fun onDestroy() {
        this.view = null
    }

    companion object{
        private val TEST_DATA = Artist(
            profile = "https://images.app.goo.gl/4atuUCBZnqsuAm7H9",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null"
        )
    }
}
