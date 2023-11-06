package com.movieapp.domain.repository

import com.movieapp.data.model.Movie


interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>

}