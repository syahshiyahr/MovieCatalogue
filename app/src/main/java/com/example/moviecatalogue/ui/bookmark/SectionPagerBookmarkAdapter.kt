package com.example.moviecatalogue.ui.bookmark

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moviecatalogue.R
import com.example.moviecatalogue.ui.bookmark.movie.MovieBookmarkFragment
import com.example.moviecatalogue.ui.bookmark.tvshow.TVShowBookmarkFragment

class SectionPagerBookmarkAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)  {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvshows)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieBookmarkFragment()
            1 -> TVShowBookmarkFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2
}