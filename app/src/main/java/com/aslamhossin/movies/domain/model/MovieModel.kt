package com.aslamhossin.movies.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Double,
    val duration: String,
    val genre: String,
    val releasedDate: String,
    val trailerLink: String,
    var onMyWatchList: Boolean = false
) : Parcelable
