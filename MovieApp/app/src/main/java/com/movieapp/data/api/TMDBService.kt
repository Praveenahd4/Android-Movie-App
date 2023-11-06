package com.movieapp.data.api

import com.movieapp.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movies/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>
}