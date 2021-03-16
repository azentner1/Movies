package com.example.movies.feature.home.data.repository

import androidx.lifecycle.LiveData
import com.example.movies.base.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepo {
    suspend fun fetchMovies(): Flow<List<Movie>>
}
