package com.aslamhossin.movies.domain.usecases

import com.aslamhossin.movies.data.repositories.MovieRepository
import com.aslamhossin.movies.domain.model.MovieModel
import javax.inject.Inject

/**
 * Created by aslam on 10,January,2023
 */
class SaveMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {

    suspend operator fun invoke(movieModel: MovieModel) =
        movieRepository.saveMovieOnMyWishList(movieModel)
}