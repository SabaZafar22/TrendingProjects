package com.example.trendingprojects.repositories.di

import com.example.trendingprojects.repositories.api.DefaultTrendingProjectsService
import com.example.trendingprojects.repositories.api.TrendingProjectsService
import com.example.trendingprojects.repositories.data.DefaultTrendingProjectsRepository
import com.example.trendingprojects.repositories.data.TrendingProjectsRepository
import com.example.trendingprojects.repositories.domain.DefaultTrendingProjectsUseCase
import com.example.trendingprojects.repositories.domain.TrendingProjectsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Bindings {
    @Binds
    abstract fun bindService(default: DefaultTrendingProjectsService): TrendingProjectsService

    @Binds
    abstract fun bindUseCase(default: DefaultTrendingProjectsUseCase): TrendingProjectsUseCase

    @Binds
    abstract fun bindRepo(default: DefaultTrendingProjectsRepository): TrendingProjectsRepository
}