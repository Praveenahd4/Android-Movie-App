package com.movieapp.presentation.di

import com.movieapp.data.api.TMDBService
import com.movieapp.data.datasource.MovieRemoteDataSource
import com.movieapp.data.datasourceImpl.MovieRemoteDataSourceImpl
import com.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }
}