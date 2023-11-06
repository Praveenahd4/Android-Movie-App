package com.movieapp.presentation.di

import com.movieapp.data.MovieRepositoryImpl
import com.movieapp.data.datasource.MovieCacheDataSource
import com.movieapp.data.datasource.MovieLocalDataSource
import com.movieapp.data.datasource.MovieRemoteDataSource
import com.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource

    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieCacheDataSource,
            movieLocalDataSource
        )

    }

}