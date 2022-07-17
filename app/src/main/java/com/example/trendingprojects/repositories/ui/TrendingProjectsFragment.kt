package com.example.trendingprojects.repositories.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trendingprojects.databinding.FragmentTrendingProjectsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingProjectsFragment : Fragment() {

    private lateinit var binding: FragmentTrendingProjectsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrendingProjectsListBinding.inflate(inflater, container, false)
        return binding.root
    }
}