package com.example.moviecatalogue.ui.bookmark.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.FragmentTvShowBookmarkBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TVShowBookmarkFragment : Fragment() {

    private var _binding: FragmentTvShowBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTvShowBookmarkBinding.inflate(inflater, container, false)
        return binding.root

    }
}