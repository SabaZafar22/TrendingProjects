package com.example.trendingprojects.repositories.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.trendingprojects.databinding.FragmentTrendingProjectsListBinding
import com.example.trendingprojects.repositories.vm.TrendingProjectsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingProjectsFragment : Fragment() {

    private lateinit var binding: FragmentTrendingProjectsListBinding

    private val trendingProjectsViewModel: TrendingProjectsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrendingProjectsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBindings()
        trendingProjectsViewModel.getProjects()
    }

    private fun initBindings() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = trendingProjectsViewModel
            adapter = TrendingProjectsAdapter()
        }
    }

    fun refresh() {
        trendingProjectsViewModel.getProjects(true)
    }
}