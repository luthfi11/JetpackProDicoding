package com.luthfi.moviecatalogue.ui.tvdetail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.TVShow
import kotlinx.android.synthetic.main.activity_detail.*

class TVShowDetailActivity : AppCompatActivity() {

    private lateinit var viewModelMovie: TVShowDetailViewModel
    private val imgUrl = "https://image.tmdb.org/t/p/w185/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModelMovie = ViewModelProviders.of(this).get(TVShowDetailViewModel::class.java)

        val tvData = intent.getParcelableExtra<TVShow>("tv")
        if (tvData != null) {
            viewModelMovie.getTVShow(tvData).observe(this, Observer {
                showTVDetail(it)
            })
        }
    }

    private fun showTVDetail(tvShow: TVShow?) {
        Glide.with(this).load(imgUrl+tvShow?.poster_path).placeholder(android.R.color.darker_gray).into(imgMovie)
        Glide.with(this).load(imgUrl+tvShow?.backdrop_path).placeholder(android.R.color.darker_gray).into(imgBackdrop)

        tvTitle.text = tvShow?.name
        tvReleaseDate.text = tvShow?.first_air_date
        tvRating.text =
            String.format(getString(R.string.vote), tvShow?.vote_average, tvShow?.vote_count)
        tvOverview.text = tvShow?.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
