package com.movieapp.presentation
import androidx.lifecycle.liveData
import androidx.lifecycle.ViewModel
import com.movieapp.domain.usecases.GetMovieUseCase
import com.movieapp.domain.usecases.UpdateMovieUseCase


class MyViewModel(private val getMovieUseCase: GetMovieUseCase,
                  private val updateMovieUseCase: UpdateMovieUseCase):ViewModel() {
        fun getMovies() = liveData{
            val movieList = getMovieUseCase.execute()
            emit(movieList)
        }
    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}