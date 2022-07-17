package com.example.trendingprojects.repositories.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Failure(val error: String) : ResponseResult<Nothing>()
}

suspend fun <T> callApi(apiCall: suspend () -> T): ResponseResult<T> {
    return withContext(Dispatchers.IO) {
        try {
            val result = apiCall.invoke()
            ResponseResult.Success(result)
        } catch (throwable: Throwable) {
            ResponseResult.Failure("Test")
        }
    }
}