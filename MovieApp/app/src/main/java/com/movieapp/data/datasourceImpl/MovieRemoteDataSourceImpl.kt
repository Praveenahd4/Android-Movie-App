package com.movieapp.data.datasourceImpl

import com.movieapp.data.api.TMDBService
import com.movieapp.data.datasource.MovieRemoteDataSource
import com.movieapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
    private val apiKey: String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}