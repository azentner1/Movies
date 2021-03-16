package com.example.movies.feature.home.adaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.base.ext.setImage
import com.example.movies.base.model.Movie
import kotlinx.android.synthetic.main.list_item_movies.view.*

class MoviesAdapter(private var list: MutableList<Movie> = mutableListOf(), val onMovieClick: (movie: Movie) -> Unit) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_movies, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]
        holder.title.text = movie.title
        holder.image.setImage(movie.posterImage)
        holder.itemView.setOnClickListener {
            onMovieClick(movie)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(moviesList: List<Movie>) {
        this.list.addAll(moviesList)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.ivMoviesItemImage
        val title: TextView = view.txtMoviesItemTitle
    }

}
