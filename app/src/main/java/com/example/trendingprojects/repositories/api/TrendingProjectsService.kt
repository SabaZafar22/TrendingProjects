package com.example.trendingprojects.repositories.api

import com.example.trendingprojects.repositories.domain.TrendingProjectsResponse
import com.example.trendingprojects.repositories.utils.ResponseResult
import com.example.trendingprojects.repositories.utils.callApi
import javax.inject.Inject

interface TrendingProjectsService {
    suspend fun getTrendingProjects(): ResponseResult<TrendingProjectsResponse>
}

class DefaultTrendingProjectsService @Inject constructor(private val api: TrendingProjectsApi) :
    TrendingProjectsService {
    override suspend fun getTrendingProjects(): ResponseResult<TrendingProjectsResponse> {
        return callApi { api.getTrendingProjects() }
    }
}