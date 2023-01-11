package com.aslamhossin.movies.data.remote.mapper

import com.aslamhossin.movies.data.remote.responses.MovieResponse
import com.aslamhossin.movies.domain.model.MovieModel

/**
 * Created by aslam on 10,January,2023
 */


class MovieModelMapper : Mapper<MovieModel, MovieResponse> {

    override fun map(from: MovieModel): MovieResponse {
        return from.run {
            MovieResponse(
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
