package com.movieapp.presentation.di

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}