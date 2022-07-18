package com.example.trendingprojects.repositories.domain

import com.example.trendingprojects.repositories.data.TrendingProjectsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface TrendingProjectsUseCase {
    fun getTrendingProjects(refresh: Boolean): Flow<TrendingProjectUiState>
}

class DefaultTrendingProjectsUseCase @Inject constructor(val trendingProjectsRepository: TrendingProjectsRepository) :
    TrendingProjectsUseCase {
    override fun getTrendingProjects(refresh: Boolean): Flow<TrendingProjectUiState> {
        return flow {

        }
    }

}