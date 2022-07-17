package com.example.trendingprojects.repositories.domain

import com.squareup.moshi.Json

data class Projects(
    val id: Double,
    val name: String,
    @Json(name = "full_name")
    val fullName: String,
    val description: String,
    val language: String,
    @Json(name = "stargazers_count")
    val starsCount: Double,
    val owner: Owner
)

data class Owner(
    @Json(name = "avatar_url")
    val image: String
)
