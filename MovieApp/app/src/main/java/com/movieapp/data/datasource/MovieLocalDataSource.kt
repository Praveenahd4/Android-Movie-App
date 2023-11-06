package com.movieapp.data.datasource

import com.movieapp.data.model.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>

    suspend fun saveMoviesToDB(movies:List<Movie>)

    suspend fun clearAll()
}