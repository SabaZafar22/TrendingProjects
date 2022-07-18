package com.example.trendingprojects.repositories.domain

data class ProjectsUiModel(
    val name: String,
    val fullName: String,
    val description: String,
    val language: String,
    val starsCount: Double,
    val image: String
){
    val count = starsCount.toString()
}