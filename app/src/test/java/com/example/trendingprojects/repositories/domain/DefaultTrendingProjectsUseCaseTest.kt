package com.example.trendingprojects.repositories.domain

import com.example.trendingprojects.repositories.data.TrendingProjectsRepository
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DefaultTrendingProjectsUseCaseTest : TestCase() {
    lateinit var useCase: DefaultTrendingProjectsUseCase

    @Mock
    lateinit var repository: TrendingProjectsRepository

    @Before
    fun setup() {
        useCase = DefaultTrendingProjectsUseCase(repository)
    }

    @Test
    fun `Given Failure Response When getProjects is called Then Failure State must be return`() =
        runBlocking {
            val states = ArrayList<TrendingProjectUiState>()

            useCase.getTrendingProjects(false).collectLatest {
                states.add(it)
            }

            assert(states[0] is TrendingProjectUiState.Loading)
            assert(states[1] is TrendingProjectUiState.Failure)
            assert((states[1] as TrendingProjectUiState.Failure).message == "Empty")
        }


    @Test
    fun `Given Success Response When getProjects is called Then Success ui State must be return`() =
        runBlocking {

            val states = ArrayList<TrendingProjectUiState>()

            useCase.getTrendingProjects(false).collectLatest {
                states.add(it)
            }
            assert(states[0] is TrendingProjectUiState.Loading)
            assert(states[1] is TrendingProjectUiState.Success)
            assert((states[1] as TrendingProjectUiState.Success).projects == emptyList<Projects>())
        }

}