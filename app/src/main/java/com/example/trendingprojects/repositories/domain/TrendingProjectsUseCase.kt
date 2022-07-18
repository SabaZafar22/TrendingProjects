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
            emit(TrendingProjectUiState.Loading)

            when (val result = trendingProjectsRepository.getProjects(refresh)) {
                is TrendingProjectsState.Success -> emit(onSuccess(result.projects))
                is TrendingProjectsState.Failure -> emit(onFailure(result))
            }
        }
    }

    private fun onFailure(result: TrendingProjectsState.Failure) =
        TrendingProjectUiState.Failure(result.message)


    private fun onSuccess(projects: List<Projects>) =
        TrendingProjectUiState.Success(projects.map {
            ProjectsUiModel(
                it.name,
                it.fullName,
                it.description,
                it.language?: "",
                it.starsCount,
                it.owner.image
            )
        })

}