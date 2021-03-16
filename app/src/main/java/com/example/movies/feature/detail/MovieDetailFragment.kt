package com.example.movies.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.movies.R
import com.example.movies.base.ext.setImage
import kotlinx.android.synthetic.main.fragment_movies_detail.*

class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        val movie = args.movie
        ivMovieDetailsPoster.setImage(movie.posterImage)
        ivMovieDetailsBackdrop.setImage(movie.backdropImage)
        txtMovieDetailsReleaseDate.text = movie.releaseDate
        txtMovieDetailsTitle.text = movie.title
        txtMovieDetailsSummary.text = movie.summary
    }
}
