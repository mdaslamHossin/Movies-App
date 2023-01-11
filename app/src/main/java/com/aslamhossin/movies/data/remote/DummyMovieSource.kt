package com.aslamhossin.movies.data.remote

import com.aslamhossin.movies.data.remote.responses.MovieResponse

/**
 * Created by aslam on 01,January,2023
 */

object DummyMovieSource {
    fun getMovies() = listOf(
        MovieResponse(
            1,
            "Tenet",
            "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a " +
                    "mission that will unfold in something beyond real time.",
            7.8,
            "2h 30 min",
            "Action, Sci-Fi",
            " 3 September 2020",
            "https://www.youtube.com/watch?v=LdOM0x0XDMo"
        ),
        MovieResponse(
            2,
            "Spider-Man: Into the Spider-Verse",
            "Description: Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat " +
                    "for all realities",
            8.4,
            "1h 57min",
            "Action, Animation, Adventure",
            "14 December 2018",
            "https://www.youtube.com/watch?v=tg52up16eq0"
        ),
        MovieResponse(
            3,
            "Knives Out",
            "A detective investigates the death of a patriarch of an eccentric, combative family.",
            7.9,
            "2h 10min",
            "Comedy, Crime, Drama",
            "27 November 2019",
            "https://www.youtube.com/watch?v=qGqiHJTsRkQ"
        ),

        MovieResponse(
            4,
            "Guardians of the Galaxy",
            "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.",
            8.0,
            "2h 1min",
            "Action, Adventure, Comedy",
            "1 August 2014",
            "https://www.youtube.com/watch?v=d96cjJhvlMA"
        ),
        MovieResponse(
            5,
            "Avengers: Age of Ultron",
            "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to" +
                    " stop the villainous Ultron from enacting his terrible plan.",
            7.3,
            " 2h 21min",
            "Action, Adventure, Sci-Fi",
            "1 May 2015",
            "https://www.youtube.com/watch?v=tmeOjFno6Do"
        )
    )
}