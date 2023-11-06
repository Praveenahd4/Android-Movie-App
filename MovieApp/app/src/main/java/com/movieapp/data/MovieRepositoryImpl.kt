package com.movieapp.data

import com.movieapp.data.datasource.MovieCacheDataSource
import com.movieapp.data.datasource.MovieLocalDataSource
import com.movieapp.data.datasource.MovieRemoteDataSource
import com.movieapp.data.model.Movie
import com.movieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }


    suspend fun getMoviesFromAPI(): List<Movie> {

        lateinit var movieList: List<Movie>

        try{
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null){
                movieList = body.movies
            }
        }catch (exception: java.lang.Exception){

        }
        return movieList
    }

    suspend fun getMoviesFromROOM():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception:Exception){

        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }


    suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList : List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){

        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}