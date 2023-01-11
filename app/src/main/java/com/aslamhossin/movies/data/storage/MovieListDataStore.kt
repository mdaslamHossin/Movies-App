package com.aslamhossin.movies.data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.aslamhossin.movies.arch.data.SharedPreferenceDataStore
import com.aslamhossin.movies.data.remote.responses.MovieResponse
import javax.inject.Inject

/**
 * Created by aslam on 10,January,2023
 */
class MovieListDataStore @Inject constructor(
    dataStore: DataStore<Preferences>
): SharedPreferenceDataStore<MovieResponse> (dataStore,MovieResponse.serializer())
