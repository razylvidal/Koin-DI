package com.codesthetic.devcon_koin.ui

import com.codesthetic.devcon_koin.core.domain.Artist

/**
 * Created by razylvidal on September 28, 2023
 */
interface ArtistContract {

    interface View {

        fun showLoadingDialog(isShowing: Boolean = false)
        fun displayArtist(artist: Artist)
        fun showToast(message :String)
    }

    interface Presenter {
        fun onViewReady(view : View)
        fun onRandomize()
        fun onDestroy()
    }

    interface Model

}
