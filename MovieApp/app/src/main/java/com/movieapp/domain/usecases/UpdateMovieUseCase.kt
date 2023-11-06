package com.movieapp.domain.usecases

import com.movieapp.data.model.Movie
import com.movieapp.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>?=movieRepository.updateMovies()
}