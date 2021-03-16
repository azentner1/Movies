package com.example.movies.base.di

import android.util.Base64
import com.example.movies.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import com.example.movies.base.datasource.api.ApiService
import com.example.movies.feature.home.data.datasource.MoviesDataSource
import com.example.movies.feature.home.data.datasource.MoviesDataSourceImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    private const val API_KEY = "api_key"

    @Provides
    @Singleton
    fun retrofit(
        @Named("logging") logging: Interceptor,
    ): Retrofit {
        val interceptor = Interceptor {
            val original = it.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY, BuildConfig.AUTHORIZATION)
                .build()
            val request = original.newBuilder()
                .url(url).build()
            return@Interceptor it.proceed(request)
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(logging)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesDataSource(apiService: ApiService): MoviesDataSource {
        return MoviesDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    @Named("logging")
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

}
