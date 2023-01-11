package com.aslamhossin.movies.arch.extensions

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*

sealed class UseCaseResult<out T> {
    data class Success<T>(val value: T) : UseCaseResult<T>()
    data class Error(val error: Throwable) : UseCaseResult<Nothing>()
}

@Suppress("TooGenericExceptionCaught")
inline fun <T> useCaseFlow(
    coroutineDispatcher: CoroutineDispatcher,
    crossinline block: suspend () -> T,

    ): Flow<UseCaseResult<T>> = flow {
    try {
        val repoResult = block()
        emit(UseCaseResult.Success(repoResult))
    } catch (e: Exception) {
        emit(UseCaseResult.Error(e))
    }
}.flowOn(coroutineDispatcher)

fun <T> Flow<UseCaseResult<T>>.onSuccess(action: suspend (T) -> Unit): Flow<UseCaseResult<T>> =
    transform { result ->
        if (result is UseCaseResult.Success<T>) {
            action(result.value)
        }
        return@transform emit(result)
    }

