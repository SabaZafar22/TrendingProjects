package com.example.trendingprojects.repositories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.trendingprojects.R
import com.example.trendingprojects.databinding.ActivityTrendingProjectsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingProjectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrendingProjectsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trending_projects)
    }
}