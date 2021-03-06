package com.luthfi.moviecatalogue.ui.favorite

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.ui.favorite.movies.MoviesFavoriteFragment
import com.luthfi.moviecatalogue.ui.favorite.tvshow.TVShowFavoriteFragment

private val TAB_TITLES = arrayOf(
    R.string.movies,
    R.string.tvshow
)

class SectionsPagerAdapter(private val context: Context?, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MoviesFavoriteFragment()
            1 -> TVShowFavoriteFragment()
            else -> MoviesFavoriteFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context?.resources?.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}