package com.luthfi.moviecatalogue.ui.detail.tvdetail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.TVShow
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

class TVShowDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: TVShowDetailViewModel
    private var tvData: TVShow? = null
    private val imgUrl = "https://image.tmdb.org/t/p/w185/"
    private var menu: Menu? = null
    private var isFav = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(TVShowDetailViewModel::class.java)

        tvData = intent.getParcelableExtra("tv")
        if (tvData != null) {
            viewModel.getTVShow(tvData!!).observe(this, Observer {
                showTVDetail(it)
            })
            viewModel.checkFavTV(tvData!!.id).observe(this, Observer {
                isFav = it.isNotEmpty()
            })
        }
    }

    private fun showTVDetail(tvShow: TVShow?) {
        imgMovie.setImage(tvShow?.poster_path)
        imgBackdrop.setImage(tvShow?.backdrop_path)
        tvTitle.text = tvShow?.name
        tvReleaseDate.text = tvShow?.first_air_date
        tvRating.text = String.format(getString(R.string.vote), tvShow?.vote_average, tvShow?.vote_count)
        tvOverview.text = tvShow?.overview
    }

    private fun ImageView.setImage(src: String?) {
        Glide.with(this).load(imgUrl + src).placeholder(android.R.color.darker_gray).into(this)
    }

    private fun changeIcon(drawable: Int) {
        menu?.getItem(0)?.icon = ContextCompat.getDrawable(this, drawable)
    }

    private fun setFavorite(isFav: Boolean) {
        if (isFav) changeIcon(R.drawable.ic_favorite)
        else changeIcon(R.drawable.ic_favorite_border)
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menu = menu
        setFavorite(isFav)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.addToFav -> {
                if (isFav) {
                    setFavorite(false)
                    toast("Removed from Favorite")
                    viewModel.deleteTVFav(tvData!!)
                }
                else {
                    setFavorite(true)
                    toast("Added to Favorite")
                    viewModel.addTVFav(tvData!!)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
