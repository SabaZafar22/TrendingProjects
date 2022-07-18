package com.example.trendingprojects.repositories.data

import com.example.trendingprojects.repositories.MainCoroutinesRule
import com.example.trendingprojects.repositories.api.TrendingProjectsService
import com.example.trendingprojects.repositories.db.ProjectsDao
import com.example.trendingprojects.repositories.domain.Owner
import com.example.trendingprojects.repositories.domain.Projects
import com.example.trendingprojects.repositories.domain.TrendingProjectsResponse
import com.example.trendingprojects.repositories.domain.TrendingProjectsState
import com.example.trendingprojects.repositories.utils.ResponseResult
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DefaultTrendingProjectsRepositoryTest : TestCase() {
    lateinit var trendingProjectsRepository: DefaultTrendingProjectsRepository

    @Mock
    lateinit var trendingProjectsService: TrendingProjectsService

    @Mock
    lateinit var projectsDao: ProjectsDao

    private val dispatcher = MainCoroutinesRule().testDispatcher

    @Before
    fun setup() {
        trendingProjectsRepository =
            DefaultTrendingProjectsRepository(trendingProjectsService, projectsDao, dispatcher)
    }

    @Test
    fun `Given List from db When getProjects is called Then Succes State must be return`() =
        runBlocking {
            whenever(projectsDao.getProjects()).thenReturn(
                getListOfProjects()
            )

            val result = trendingProjectsRepository.getProjects()

            assert(result is TrendingProjectsState.Success)
            assert(
                (result as TrendingProjectsState.Success).projects == getListOfProjects()
            )
        }

    @Test
    fun `Given Success Api Response When getProjects is called Then Success State must be return`() =
        runBlocking {
            whenever(projectsDao.getProjects()).thenReturn(
                emptyList()
            )
            whenever(trendingProjectsService.getTrendingProjects()).thenReturn(
                getSuccessResponse()
            )

            whenever(
                projectsDao.insertProjects(
                    getListOfProjects()
                )
            ).thenReturn(Unit)

            val result = trendingProjectsRepository.getProjects()

            assert(result is TrendingProjectsState.Success)
            assert(
                (result as TrendingProjectsState.Success).projects == emptyList<Projects>()
            )
        }

    private fun getSuccessResponse() = ResponseResult.Success(
        TrendingProjectsResponse(
            getListOfProjects()
        )
    )

    private fun getListOfProjects() = listOf(
        Projects(
            1.0,
            "Saba",
            "Saba Zafar",
            "Description",
            "python",
            2.0,
            Owner("")
        )
    )

    @Test
    fun `Given Failure Api Response When getProjects is called Then Failure State must be return`() =
        runBlocking {
            whenever(projectsDao.getProjects()).thenReturn(
                emptyList()
            )
            whenever(trendingProjectsService.getTrendingProjects()).thenReturn(
                getFailureResponse()
            )

            val result = trendingProjectsRepository.getProjects()

            assert(result is TrendingProjectsState.Failure)
            assert(
                (result as TrendingProjectsState.Failure).message == "Error"
            )
        }

    private fun getFailureResponse() = ResponseResult.Failure("Error")
}