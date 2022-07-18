package com.example.trendingprojects.repositories.domain

sealed class TrendingProjectsState {
    data class Failure(val message: String) : TrendingProjectsState()
    data class Success(val projects: List<Projects>) : TrendingProjectsState()
}

sealed class TrendingProjectUiState {
    data class Failure(val message: String) : TrendingProjectUiState()
    data class Success(val projects: List<ProjectsUiModel>) : TrendingProjectUiState()
    object Loading: TrendingProjectUiState()
}