package com.luthfi.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        val movie = viewModel.getDetail(intent.getParcelableExtra("data"))

        Glide.with(this).load(movie?.poster).placeholder(android.R.color.darker_gray).into(imgMovie)
        tvTitle.text = movie?.title
        tvYear.text = movie?.year
        tvOverview.text = movie?.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
