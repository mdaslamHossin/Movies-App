package com.aslamhossin.movies.data.remote.mapper

internal interface Mapper<FROM, TO> {
    fun map(from: FROM): TO
}