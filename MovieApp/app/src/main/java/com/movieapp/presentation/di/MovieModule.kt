package com.movieapp.presentation.di

import com.movieapp.domain.usecases.GetMovieUseCase
import com.movieapp.domain.usecases.UpdateMovieUseCase
import com.movieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides
@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ):ViewModelFactory{
        return ViewModelFactory(getMovieUseCase,updateMovieUseCase)
    }
}