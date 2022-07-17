package com.example.trendingprojects.repositories.domain

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "trending_projects")
data class Projects(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    val id: Double,
    val name: String,
    @Json(name = "full_name")
    val fullName: String,
    val description: String,
    val language: String,
    @Json(name = "stargazers_count")
    val starsCount: Double,
    @Embedded
    val owner: Owner
)

data class Owner(
    @Json(name = "avatar_url")
    val image: String
)
