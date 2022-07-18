package com.example.trendingprojects.repositories.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trendingprojects.repositories.domain.TrendingProjectUiState
import com.example.trendingprojects.repositories.domain.TrendingProjectsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingProjectsListViewModel @Inject constructor(val trendingProjectsUseCase: TrendingProjectsUseCase) :
    ViewModel() {

    private val _projectsUiState = MutableLiveData<TrendingProjectUiState>()
    val projectsUiState: LiveData<TrendingProjectUiState> = _projectsUiState

    fun getProjects(refresh:Boolean = false) {
        viewModelScope.launch {
            trendingProjectsUseCase.getTrendingProjects(refresh).collectLatest {
                _projectsUiState.postValue(it)
            }
        }
    }
}