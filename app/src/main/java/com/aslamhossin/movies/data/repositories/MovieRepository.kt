package com.aslamhossin.movies.data.repositories

import com.aslamhossin.movies.domain.model.MovieModel

interface MovieRepository {

    suspend fun getMovies(): List<MovieModel>
    suspend fun saveMovieOnMyWishList(model: MovieModel)

}
