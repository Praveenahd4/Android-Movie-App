package com.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieapp.domain.usecases.GetMovieUseCase
import com.movieapp.domain.usecases.UpdateMovieUseCase

class ViewModelFactory(private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getMovieUseCase, updateMovieUseCase)as T
    }
}