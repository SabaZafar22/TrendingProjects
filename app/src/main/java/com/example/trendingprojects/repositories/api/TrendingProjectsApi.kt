package com.example.trendingprojects.repositories.api

import com.example.trendingprojects.repositories.domain.TrendingProjectsResponse
import retrofit2.http.GET

interface TrendingProjectsApi {
    @GET("search/repositories?q=language=+sort:stars")
    suspend fun getTrendingProjects(): TrendingProjectsResponse

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}