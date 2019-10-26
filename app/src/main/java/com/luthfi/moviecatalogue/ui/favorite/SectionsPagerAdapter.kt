package com.luthfi.moviecatalogue.ui.favorite

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.ui.movies.MoviesFragment
import com.luthfi.moviecatalogue.ui.tvshow.TVShowFragment

private val TAB_TITLES = arrayOf(
    R.string.movies,
    R.string.tvshow
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MoviesFragment()
            1 -> TVShowFragment()
            else -> MoviesFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}