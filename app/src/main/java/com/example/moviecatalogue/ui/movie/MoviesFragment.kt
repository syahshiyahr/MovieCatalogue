package com.example.moviecatalogue.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.databinding.FragmentMoviesBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movie ->
                if(movie != null){
                    when(movie.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            moviesAdapter.setMovies(movie.data)
                            moviesAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })


            with(binding.rvMovies){
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = moviesAdapter
            }
        }
    }
}