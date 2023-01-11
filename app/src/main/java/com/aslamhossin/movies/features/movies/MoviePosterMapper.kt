package com.aslamhossin.movies.features.movies

import com.aslamhossin.movies.R


/**
 * Created by aslam on 10,January,2023
 */

object MoviePosterMapper {
    fun getPoster(title: String): Int {
        val posterNameMatcher = title.split(" ").first().lowercase()
        return if (posterNameMatcher.contains("tenet")) R.drawable.tenet
        else if (posterNameMatcher.contains("spider")) R.drawable.spider_man
        else if (posterNameMatcher.contains("knives")) R.drawable.knives_out
        else if (posterNameMatcher.contains("guardians")) R.drawable.guardians_of_the_galaxy
        else R.drawable.avengers

    }
}