package com.example.movies.feature.home

import android.text.method.MovementMethod
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.movies.base.model.Movie
import com.example.movies.feature.home.data.repository.MoviesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class MoviesViewModel @ViewModelInject constructor(private val moviesRepo: MoviesRepo) : ViewModel() {

    private val _uiState = MutableStateFlow<List<Movie>>(listOf())
    val uiState: StateFlow<List<Movie>> = _uiState

    fun fetchMovies() {
        viewModelScope.launch {
            val movies = moviesRepo.fetchMovies()
            movies.collect {
                _uiState.value = it
            }
        }
    }
}
