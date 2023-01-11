package com.aslamhossin.movies.features.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aslamhossin.movies.arch.extensions.onSuccess
import com.aslamhossin.movies.domain.model.MovieModel
import com.aslamhossin.movies.domain.usecases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {


    private val _teamFlow: MutableStateFlow<List<MovieModel>> = MutableStateFlow(emptyList())
    val teamFlow = _teamFlow.asStateFlow()

    fun getMovies() {
        getMoviesUseCase()
            .onSuccess {
                _teamFlow.emit(it)
            }
            .launchIn(viewModelScope)
    }

}
