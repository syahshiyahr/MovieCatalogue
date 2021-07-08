package com.example.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.TVShowEntity
import com.example.moviecatalogue.data.source.local.entity.TVShow
import com.example.moviecatalogue.databinding.ItemsTvShowBinding
import com.example.moviecatalogue.ui.detail.DetailActivity
import com.example.moviecatalogue.utils.Constants.IMG_URL

class TVShowAdapter: RecyclerView.Adapter<TVShowAdapter.ShowViewHolder>() {
    private var listTvShows = ArrayList<TVShow>()

    fun setTvShows(tvShows: List<TVShow>?){
        if(tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }
    class ShowViewHolder(private val binding: ItemsTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TVShow){
            with(binding){
                tvTitle.text = tvShows.title
                tvDate.text = tvShows.releaseDate
                tvRating.text = tvShows.rating
                tvOverview.text = tvShows.desc
                Glide.with(itemView.context)
                    .load(IMG_URL + tvShows.image)
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, tvShows.tvShowId)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "TV Show")
                    itemView.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemsTvShowBinding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size
}