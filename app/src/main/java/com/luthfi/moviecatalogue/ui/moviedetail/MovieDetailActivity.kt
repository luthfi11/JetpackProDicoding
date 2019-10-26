package com.luthfi.moviecatalogue.ui.moviedetail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var viewModelMovie: MovieDetailViewModel
    private val imgUrl = "https://image.tmdb.org/t/p/w185/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModelMovie = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)

        val movieData = intent.getParcelableExtra<Movie>("movie")
        if (movieData != null) {
            viewModelMovie.getMovie(movieData).observe(this, Observer {
                showMovieDetail(it)
            })
        }
    }

    private fun showMovieDetail(movie: Movie?) {
        Glide.with(this).load(imgUrl + movie?.poster_path).placeholder(android.R.color.darker_gray).into(imgMovie)
        Glide.with(this).load(imgUrl + movie?.backdrop_path).placeholder(android.R.color.darker_gray).into(imgBackdrop)

        tvTitle.text = movie?.title
        tvReleaseDate.text = movie?.release_date
        tvRating.text = String.format(getString(R.string.vote), movie?.vote_average, movie?.vote_count)
        tvOverview.text = movie?.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
