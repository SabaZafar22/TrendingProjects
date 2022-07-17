package com.example.trendingprojects.repositories.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trendingprojects.R
import com.example.trendingprojects.databinding.FragmentTrendingProejctsBinding

class TrendingProjectsFragment : Fragment() {

    lateinit var binding: FragmentTrendingProejctsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrendingProejctsBinding.inflate(inflater, container, false)
        return binding.root
    }
}