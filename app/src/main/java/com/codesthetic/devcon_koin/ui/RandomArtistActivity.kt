package com.codesthetic.devcon_koin.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import com.codesthetic.devcon_koin.R
import com.codesthetic.devcon_koin.core.domain.Artist
import com.codesthetic.devcon_koin.databinding.RandomArtistBinding
import org.koin.android.ext.android.get

/**
 * Created by razylvidal on September 28, 2023
 */
class RandomArtistActivity : AppCompatActivity(), ArtistContract.View {

    private lateinit var binding: RandomArtistBinding

    private val presenter = ArtistViewModel(get())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RandomArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShuffle.setOnClickListener {
            presenter.onRandomize()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.onViewReady(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoadingDialog(isShowing: Boolean) {
        if (isShowing) {
            binding.llContainer.visibility = View.GONE
        } else {
            binding.llContainer.visibility = View.VISIBLE
        }
    }

    @SuppressLint("SetTextI18n")
    override fun displayArtist(artist: Artist) {
        binding.image.load(artist.profile)
        binding.tvStageName.text = artist.stageName
        binding.tvKoreanStageName.text = "[ ${artist.koreanStageName} ]"
        binding.tvGroup.text = artist.group
        binding.tvFullname.text = "Fullname : ${artist.fullName}"
        binding.tvKoreanName.text = "Korean Name : ${artist.koreanName}"
        binding.dateOfBirth.text = "Date of Birth : ${artist.dateOfBirth}"
        binding.birthplace.text = "Birthplace : ${artist.birthplace}"
        binding.group.text = "Group : ${artist.group}"
        binding.country.text = "Country : ${artist.country}"
        binding.gender.text = "Gender : ${artist.gender}"
        binding.position.text = "Position : ${artist.position}"
        binding.instagram.text = "Instagram : ${artist.instagram}"
        binding.twitter.text = "Twitter : ${artist.twitter}"
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    companion object{
        suspend fun ImageView.loadImage(url : String, imageLoader : ImageLoader) {
            val request = ImageRequest.Builder(context)
                .data(url)
                .error(R.drawable.ic_launcher_background)
                .build()
            val drawable = imageLoader.execute(request).drawable
        }
    }
}
