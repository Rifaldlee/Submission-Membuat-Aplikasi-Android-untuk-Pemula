package com.example.submissionandroidrifaldlee

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailMovie : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "key_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val tvtitle:TextView  = findViewById(R.id.detail_title)
        val tvrating:TextView  = findViewById(R.id.detail_rating)
        val tvyear:TextView  = findViewById(R.id.detail_year)
        val tvgenre:TextView  = findViewById(R.id.detail_genre)
        val tvduration:TextView  = findViewById(R.id.detail_duration)
        val tvcountry:TextView  = findViewById(R.id.detail_country)
        val tvsynopsis:TextView  = findViewById(R.id.detail_synopsis)
        val imgposter:ImageView = findViewById(R.id.detail_img)

        val dataMovie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Movie>(EXTRA_MOVIE, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        }
        if (dataMovie != null) {
            val title = "${dataMovie.title}"
            tvtitle.text = title

            val rating = "${dataMovie.rating}"
            tvrating.text = rating

            val year = "${dataMovie.year}"
            tvyear.text = year

            val genre = "${dataMovie.genre}"
            tvgenre.text = genre

            val duration = "${dataMovie.duration}"
            tvduration.text = duration

            val country = "${dataMovie.country}"
            tvcountry.text = country

            val synopsis = "${dataMovie.synopsis}"
            tvsynopsis.text = synopsis

            val imageResourceId = dataMovie.poster
            imgposter.setImageResource(imageResourceId)
        }

    }
}