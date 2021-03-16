package com.example.movies.base.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.movies.BuildConfig

fun ImageView.setImage(url: String) {
    println(BuildConfig.IMAGE_API_URL + url)
    Glide.with(this).load(BuildConfig.IMAGE_API_URL + url).into(this)
}