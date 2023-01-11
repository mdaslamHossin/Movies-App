package com.aslamhossin.movies.data.remote.mapper

import com.aslamhossin.movies.data.remote.responses.MovieResponse
import com.aslamhossin.movies.domain.model.MovieModel


class MovieResponseMapper : Mapper<MovieResponse, MovieModel> {

    override fun map(from: MovieResponse): MovieModel {
        return from.run {
            MovieModel(
                id = id,
                title = title,
                description = description,
                rating = rating,
                duration = duration,
                genre = genre,
                releasedDate = releasedDate,
                trailerLink = trailerLink,
                onMyWatchList = onMyWatchList
            )
        }
    }
}
