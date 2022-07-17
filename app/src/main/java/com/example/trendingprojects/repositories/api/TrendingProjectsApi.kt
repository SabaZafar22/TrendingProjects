package com.example.trendingprojects.repositories.api

import com.example.trendingprojects.repositories.domain.TrendingProjectsResponse

interface TrendingProjectsApi {

    suspend fun getTrendingProjects(): TrendingProjectsResponse

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}