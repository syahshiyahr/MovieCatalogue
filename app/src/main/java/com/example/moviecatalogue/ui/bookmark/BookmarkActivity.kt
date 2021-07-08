package com.example.moviecatalogue.ui.bookmark

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.ActivityBookmarkBinding
import com.example.moviecatalogue.databinding.ActivityHomeBinding
import com.example.moviecatalogue.databinding.ContentBookmarkBinding
import com.example.moviecatalogue.ui.home.SectionPagerAdapter

class BookmarkActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var activityBookmarkBinding: ActivityBookmarkBinding
    private lateinit var binding: ActivityBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityBookmarkBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sectionsPagerAdapter = SectionPagerBookmarkAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        supportActionBar?.elevation = 0f
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}