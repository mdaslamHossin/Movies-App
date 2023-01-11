package com.aslamhossin.movies.injection.modules

import com.aslamhossin.movies.data.remote.mapper.MovieModelMapper
import com.aslamhossin.movies.data.remote.mapper.MovieResponseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MapperModule {

    @Singleton
    @Provides
    fun provideMovieResponseMapper() = MovieResponseMapper()

    @Singleton
    @Provides
    fun provideMovieModelMapper() = MovieModelMapper()

}
