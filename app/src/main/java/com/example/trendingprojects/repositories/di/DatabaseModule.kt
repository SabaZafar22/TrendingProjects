package com.example.trendingprojects.repositories.di

import android.content.Context
import com.example.trendingprojects.repositories.db.ProjectsDao
import com.example.trendingprojects.repositories.db.RoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDb {
        return RoomDb.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideProjectsDao(roomDB: RoomDb): ProjectsDao {
        return roomDB.trendingProjectsDao()
    }
}