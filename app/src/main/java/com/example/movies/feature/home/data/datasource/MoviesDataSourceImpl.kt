package com.example.movies.feature.home.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movies.base.datasource.api.ApiService
import com.example.movies.base.model.Movie
import com.example.movies.feature.home.data.model.MoviesResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MoviesDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    MoviesDataSource {

    override suspend fun fetchTopPopularMovies(): Response<MoviesResponse> {
        return apiService.fetchTopPopularMovies()
    }

    override suspend fun fetchTopRatedMovies(): Response<MoviesResponse> {
        return apiService.fetchTopRatedMovies()
    }
}
