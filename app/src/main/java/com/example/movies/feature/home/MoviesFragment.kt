package com.example.movies.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import com.example.movies.base.model.Movie
import com.example.movies.feature.home.adaper.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModels()

    private val moviesAdapter by lazy {
        MoviesAdapter(
            onMovieClick = {
                openMovieDetails(it)
            })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initObserver()
        viewModel.fetchMovies()
    }

    private fun initUi() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = moviesAdapter
        }
    }

    private fun initObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                if (it.isEmpty()) {
                    return@collect
                }
                moviesAdapter.setData(it)
                recyclerView.isVisible = true
                pbLoadingMovies.isVisible = false
            }
        }
    }
    
    // Since we already have all the data we need, we won't make another API call when going to details
    private fun openMovieDetails(movie: Movie) {
        findNavController().navigate(MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(movie))
    }
}
