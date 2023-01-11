package com.aslamhossin.movies.data.remote.responses

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Double,
    val duration: String,
    val genre: String,
    val releasedDate: String,
    val trailerLink: String,
    val onMyWatchList: Boolean = false
)
