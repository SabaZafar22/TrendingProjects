package com.example.trendingprojects.repositories.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.trendingprojects.getOrAwaitValue
import com.example.trendingprojects.repositories.domain.ProjectsUiModel
import com.example.trendingprojects.repositories.domain.TrendingProjectUiState
import com.example.trendingprojects.repositories.domain.TrendingProjectsUseCase
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TrendingProjectsListViewModelTest : TestCase() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TrendingProjectsListViewModel

    @Mock
    lateinit var useCase: TrendingProjectsUseCase

    @Before
    fun setup() {
        viewModel = TrendingProjectsListViewModel(useCase)
    }

    @Test
    fun `Given Failure Response state When getProjects is called Then Failure ui State must be return`() =
        runBlocking {
            viewModel.getProjects()

            assert(viewModel.projectsUiState.getOrAwaitValue() is TrendingProjectUiState.Failure)
            assert((viewModel.projectsUiState.getOrAwaitValue() as TrendingProjectUiState.Failure).message == "Empty")
        }

    @Test
    fun `Given Success Response state When getProjects is called Then Success ui State must be return`() =
        runBlocking {

            viewModel.getProjects()

            assert(viewModel.projectsUiState.getOrAwaitValue() is TrendingProjectUiState.Success)
            assert((viewModel.projectsUiState.getOrAwaitValue() as TrendingProjectUiState.Success).projects == emptyList<ProjectsUiModel>())
        }
}