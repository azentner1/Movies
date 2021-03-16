package com.example.movies.feature.home.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movies.base.model.Movie
import com.example.movies.feature.home.data.model.MoviesResponse
import retrofit2.Response

interface MoviesDataSource {
    suspend fun fetchTopPopularMovies(): Response<MoviesResponse>
    suspend fun fetchTopRatedMovies(): Response<MoviesResponse>
}
