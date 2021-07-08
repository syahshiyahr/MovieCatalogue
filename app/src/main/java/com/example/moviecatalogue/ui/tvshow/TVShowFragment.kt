package com.example.moviecatalogue.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.FragmentTvShowBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status


class TVShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity!=null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]

            val tvShowAdapter = TVShowAdapter()
            viewModel.getTVShow().observe(viewLifecycleOwner, { tvShow ->
                if(tvShow != null){
                    when(tvShow.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            tvShowAdapter.setTvShows(tvShow.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })

            with(binding.rvTvShow){
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }

    }
}