package com.example.moviecatalogue.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.bumptech.glide.Glide
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.local.entity.Movie
import com.example.moviecatalogue.data.source.local.entity.TVShow
import com.example.moviecatalogue.databinding.ActivityDetailBinding
import com.example.moviecatalogue.databinding.ContentDetailBinding
import com.example.moviecatalogue.utils.Constants.IMG_URL
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityDetailBinding: ActivityDetailBinding
    private lateinit var binding: ContentDetailBinding
    private var itemType: String? = null
    private var menu: Menu? = null

    private lateinit var viewModel: DetailViewModel

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        binding = activityDetailBinding.detailContent
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        binding.progressBar.visibility = View.VISIBLE
        binding.btnBookmarked.setOnClickListener(this)

        val extras = intent.extras
        if (extras != null){
            val itemId = extras.getInt(EXTRA_ID)
            itemType = extras.getString(EXTRA_TYPE)

            if(itemId != null){
                itemType?.let { viewModel.setSelectedItem(itemId, it) }
                setState()

                if (itemType.equals("Movies", true)){
                    viewModel.getMovie().observe(this, { movies ->
                        if(movies != null){
                            when(movies.status){
                                Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                                Status.SUCCESS -> if(movies.data != null){
                                    binding.progressBar.visibility = View.GONE
                                    activityDetailBinding.detailContent.root.visibility = View.VISIBLE
                                    itemType?.let { populateMovie(movies.data, it) }
                                }
                                Status.ERROR -> {
                                    binding.progressBar.visibility = View.GONE
                                    Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }

                    })
                }else if(itemType.equals("TV Show", true)){
                    viewModel.getTVShow().observe(this, { tvShow ->
                        if(tvShow != null){
                            when(tvShow.status){
                                Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                                Status.SUCCESS -> if(tvShow.data != null){
                                    binding.progressBar.visibility = View.GONE
                                    activityDetailBinding.detailContent.root.visibility = View.VISIBLE
                                    itemType?.let { populateTVShow(tvShow.data, it) }
                                }
                                Status.ERROR -> {
                                    binding.progressBar.visibility = View.GONE
                                    Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }

                    })
                }

            }
        }
    }

    private fun setState() {
        if (itemType.equals("Movies", true)){
            viewModel.getMovie().observe(this, { movies ->
                if(movies != null){
                    when(movies.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if(movies.data != null){
                            binding.progressBar.visibility = View.GONE
                            val state = movies.data.bookmarked
                            setBookmarkState(state)
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })
        }else if(itemType.equals("TV Show", true)){
            viewModel.getTVShow().observe(this, { tvShow ->
                if(tvShow != null){
                    when(tvShow.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if(tvShow.data != null){
                            val state = tvShow.data.bookmarked
                            setBookmarkState(state)
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })
        }
    }


    private fun populateTVShow(tvShowEntity: TVShow, type: String) {
        binding.tvType.text = type
        binding.tvDate.text = tvShowEntity.releaseDate
        binding.tvRating.text = tvShowEntity.rating
        binding.textTitle.text = tvShowEntity.title
        binding.textOverview.text = tvShowEntity.desc
        Glide.with(this)
            .load(IMG_URL + tvShowEntity.image)
            .into(binding.imagePoster)


    }

    private fun populateMovie(movieEntity: Movie, type: String) {
        binding.tvType.text = type
        binding.tvDate.text = movieEntity.releaseDate
        binding.tvRating.text = movieEntity.rating
        binding.textTitle.text = movieEntity.title
        binding.textOverview.text = movieEntity.desc

        Glide.with(this)
            .load(IMG_URL + movieEntity.image)
            .into(binding.imagePoster)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setBookmarkState(state: Boolean) {
        if (state){
            binding.btnBookmarked.setImageResource(R.drawable.ic_baseline_bookmark_24)
        }else{
            binding.btnBookmarked.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_bookmarked ->
                if (itemType.equals("Movies", true)){
                    Toast.makeText(applicationContext, viewModel.setBookmarkMovies().toString(), Toast.LENGTH_SHORT).show()
                    viewModel.setBookmarkMovies()
                }else{
                    Toast.makeText(applicationContext, "TVShow ditambahkan", Toast.LENGTH_SHORT).show()
                    viewModel.setBookmarkTVShow()
                }
        }
    }


}