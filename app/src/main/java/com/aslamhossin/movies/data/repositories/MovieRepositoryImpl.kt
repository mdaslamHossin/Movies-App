package com.aslamhossin.movies.data.repositories

import com.aslamhossin.movies.data.remote.DummyMovieSource
import com.aslamhossin.movies.data.remote.mapper.MovieModelMapper
import com.aslamhossin.movies.data.remote.mapper.MovieResponseMapper
import com.aslamhossin.movies.data.storage.MovieListDataStore
import com.aslamhossin.movies.domain.model.MovieModel
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieResponseMapper: MovieResponseMapper,
    private val movieModelMapper: MovieModelMapper,
    private val movieListDataStore: MovieListDataStore
) : MovieRepository {

    override suspend fun getMovies(): List<MovieModel> {
        val dataStoreMovieMap = movieListDataStore.getAll().associateBy { it.id }
        return DummyMovieSource.getMovies().map { movie ->
            dataStoreMovieMap[movie.id] ?: movie
        }.map { movieResponseMapper.map(it) }
    }

    override suspend fun saveMovieOnMyWishList(model: MovieModel) {
        movieListDataStore.add(movieModelMapper.map(model))
    }

}

