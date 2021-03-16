package com.example.movies.base.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import com.example.movies.feature.home.data.repository.MoviesRepo
import com.example.movies.feature.home.data.repository.MoviesRepoImpl
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun providesMoviesRepo(MoviesRepo: MoviesRepoImpl): MoviesRepo
}
