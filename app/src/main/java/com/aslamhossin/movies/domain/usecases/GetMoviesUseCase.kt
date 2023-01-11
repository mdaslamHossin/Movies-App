package com.aslamhossin.movies.domain.usecases

import com.aslamhossin.movies.arch.extensions.useCaseFlow
import com.aslamhossin.movies.data.repositories.MovieRepository
import com.aslamhossin.movies.injection.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val teamRepository: MovieRepository,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    operator fun invoke() = useCaseFlow(coroutineDispatcher) {
        teamRepository.getMovies()
    }

}
