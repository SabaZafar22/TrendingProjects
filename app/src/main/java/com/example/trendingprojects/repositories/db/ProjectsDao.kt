package com.example.trendingprojects.repositories.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.trendingprojects.repositories.domain.Projects

@Dao
interface ProjectsDao {
    @Insert
    suspend fun insertProjects(projects: List<Projects>)

    @Transaction
    @Query("SELECT * FROM trending_projects")
    fun getProjects(): List<Projects>?

    @Query("DELETE FROM trending_projects")
    fun clear()
}