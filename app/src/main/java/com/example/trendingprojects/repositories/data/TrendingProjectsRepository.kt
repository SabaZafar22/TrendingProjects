package com.example.trendingprojects.repositories.data

import com.example.trendingprojects.repositories.api.TrendingProjectsService
import com.example.trendingprojects.repositories.db.ProjectsDao
import com.example.trendingprojects.repositories.domain.Projects
import com.example.trendingprojects.repositories.domain.TrendingProjectsState
import com.example.trendingprojects.repositories.utils.ResponseResult
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

interface TrendingProjectsRepository {
    suspend fun getProjects(refresh: Boolean): TrendingProjectsState
}

class DefaultTrendingProjectsRepository @Inject constructor(
    private val trendingProjectsService: TrendingProjectsService,
    private val projectsDao: ProjectsDao,
    private val context: CoroutineContext
) : TrendingProjectsRepository {
    override suspend fun getProjects(refresh: Boolean): TrendingProjectsState {
        return withContext(context) {

            val projects = projectsDao.getProjects()

            if (isNeedApiCall(refresh, projects)) {
                return@withContext getProjectsFromNetwork()
            }

            return@withContext TrendingProjectsState.Success(projects ?: emptyList())
        }
    }

    private fun isNeedApiCall(
        refresh: Boolean,
        projects: List<Projects>?
    ) = refresh || projects.isNullOrEmpty()

    private suspend fun getProjectsFromNetwork(): TrendingProjectsState {
        projectsDao.clear()

        val state = when (val result = trendingProjectsService.getTrendingProjects()) {
            is ResponseResult.Success -> onSuccess(result.data.items)
            is ResponseResult.Failure -> onFailure(result)
        }
        return state
    }

    private fun onFailure(result: ResponseResult.Failure) =
        TrendingProjectsState.Failure(result.error)

    private suspend fun onSuccess(data: List<Projects>): TrendingProjectsState.Success {
        projectsDao.insertProjects(data)
        return TrendingProjectsState.Success(projectsDao.getProjects() ?: emptyList())
    }
}