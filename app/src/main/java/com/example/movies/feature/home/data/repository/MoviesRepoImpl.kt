package com.example.movies.feature.home.data.repository

import androidx.lifecycle.liveData
import com.example.movies.base.model.Movie
import com.example.movies.feature.home.data.datasource.MoviesDataSource
import com.example.movies.feature.home.data.repository.MoviesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepoImpl @Inject constructor(private val moviesDataSource: MoviesDataSource) : MoviesRepo {

    override suspend fun fetchMovies() = flow {
        coroutineScope {
            val popularMovies = async { moviesDataSource.fetchTopPopularMovies() }
            val topRatedMovies = async {  moviesDataSource.fetchTopRatedMovies() }

            val movies = popularMovies.await().body()!!.movies
            val topMovies = topRatedMovies.await().body()!!.movies

            emit(movies.plus(topMovies))
        }
    }.flowOn(Dispatchers.IO)
}
