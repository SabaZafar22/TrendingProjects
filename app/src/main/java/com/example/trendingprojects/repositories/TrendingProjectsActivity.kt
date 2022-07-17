package com.example.trendingprojects.repositories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trendingprojects.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingProjectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending_projects2)
    }
}