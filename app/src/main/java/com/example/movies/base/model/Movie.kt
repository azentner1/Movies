package com.example.movies.base.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("id") val id: String,
    @SerializedName("adult") val isAdult: Boolean,
    @SerializedName("backdrop_path") val backdropImage: String,
    @SerializedName("original_language") val originLanguage: String?,
    @SerializedName("original_title") val originTitle: String,
    @SerializedName("overview") val summary: String,
    @SerializedName("popularity") val popularity: String,
    @SerializedName("poster_path") val posterImage: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: String,
    @SerializedName("vote_count") val numberOfVotes: String,
    @SerializedName("vote_average") val averageVote: String,
    @SerializedName("genre_ids") val genreIds: List<String>) : Serializable
