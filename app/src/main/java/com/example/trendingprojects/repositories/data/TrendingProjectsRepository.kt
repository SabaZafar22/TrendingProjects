package com.example.trendingprojects.repositories.data

import com.example.trendingprojects.repositories.api.TrendingProjectsService
import com.example.trendingprojects.repositories.db.ProjectsDao
import com.example.trendingprojects.repositories.domain.TrendingProjectsState
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

interface TrendingProjectsRepository {
    suspend fun getProjects(): TrendingProjectsState
}

class DefaultTrendingProjectsRepository @Inject constructor(
    private val trendingProjectsService: TrendingProjectsService,
    private val projectsDao: ProjectsDao,
    private val context: CoroutineContext
) : TrendingProjectsRepository {
    override suspend fun getProjects(): TrendingProjectsState {
        return withContext(context) {

        }
    }

}