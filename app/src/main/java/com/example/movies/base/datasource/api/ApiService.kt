package com.example.movies.base.datasource.api

import com.example.movies.feature.home.data.model.MoviesResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("3/movie/top_rated")
    suspend fun fetchTopRatedMovies(): Response<MoviesResponse>

    @GET("3/movie/popular")
    suspend fun fetchTopPopularMovies(): Response<MoviesResponse>
}
