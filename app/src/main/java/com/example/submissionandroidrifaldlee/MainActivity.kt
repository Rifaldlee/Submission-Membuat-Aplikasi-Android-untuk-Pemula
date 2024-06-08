package com.example.submissionandroidrifaldlee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val list = ArrayList<Movie>()
    private lateinit var rvMovies: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()

        val btnAbout: Button = findViewById(R.id.button)
        btnAbout.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                val movePage = Intent(this@MainActivity, About::class.java)
                startActivity(movePage)
            }
        }
    }
    private fun showSelectedMovie(movie: Movie) {
//        val moveIntent = Intent(this@MainActivity, DetailMovie::class.java)
//        startActivity(moveIntent)

        val moveWithObjectIntent = Intent(this@MainActivity, DetailMovie::class.java)
        moveWithObjectIntent.putExtra(DetailMovie.EXTRA_MOVIE, movie)
        startActivity(moveWithObjectIntent)
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val dataYear = resources.getStringArray(R.array.data_year)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataDuration = resources.getStringArray(R.array.data_duration)
        val dataCountry = resources.getStringArray(R.array.data_country)
        val dataSynopsis = resources.getStringArray(R.array.data_sinopsis)
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)
        val listMovie = ArrayList<Movie>()
        for (i in dataTitle.indices) {
            val movie = Movie(dataTitle[i], dataRating[i], dataYear[i], dataGenre[i], dataDuration[i],
                dataCountry[i], dataSynopsis[i], dataPoster.getResourceId(i, -1))
            listMovie.add(movie)
        }
        return listMovie
    }
    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val MovieAdapter = MovieAdapter(list)
        rvMovies.adapter = MovieAdapter

//        MovieAdapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Movie) {
//                showSelectedMovie(data)
//            }
//        })
    }
}