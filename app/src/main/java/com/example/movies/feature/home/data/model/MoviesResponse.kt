package com.example.movies.feature.home.data.model

import com.google.gson.annotations.SerializedName
import com.example.movies.base.model.Movie

data class MoviesResponse(
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("page") val page: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
