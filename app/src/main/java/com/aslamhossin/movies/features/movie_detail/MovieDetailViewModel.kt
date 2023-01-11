package com.aslamhossin.movies.features.movie_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aslamhossin.movies.domain.model.MovieModel
import com.aslamhossin.movies.domain.usecases.SaveMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aslam on 10,January,2023
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val saveMovieUseCase: SaveMovieUseCase) :
    ViewModel() {

    fun addMovieOnMyWishList(movieModel: MovieModel) {
        viewModelScope.launch {
            saveMovieUseCase.invoke(movieModel)
        }
    }
}