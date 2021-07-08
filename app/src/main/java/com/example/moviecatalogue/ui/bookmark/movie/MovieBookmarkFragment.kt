package com.example.moviecatalogue.ui.bookmark.movie

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
import com.example.moviecatalogue.databinding.FragmentMovieBookmarkBinding
import com.example.moviecatalogue.ui.movie.MoviesAdapter
import com.example.moviecatalogue.ui.movie.MoviesViewModel
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieBookmarkFragment : Fragment() {

    private var _binding: FragmentMovieBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieBookmarkViewModel::class.java]

            val moviesAdapter = MoviesAdapter()
            viewModel.getBookmarkMovie().observe(viewLifecycleOwner, { movie ->
                if(movie != null){
                    moviesAdapter.setMovies(movie)
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