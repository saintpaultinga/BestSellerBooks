package com.tsp.learn.android.bestsellerbooks.di

import android.app.Application
import com.tsp.learn.android.bestsellerbooks.repository.service.BookService
import com.tsp.learn.android.bestsellerbooks.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class RestModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideHttpCache(): Cache {
        return Cache(
            application.cacheDir,
            Constants.CACHE_SIZE.toLong()
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
        client.apply {
            cache(cache)
            addInterceptor(interceptor)
        }
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(Constants.BASE_API_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideNasaApiService(retrofit: Retrofit): BookService {
        return retrofit.create(BookService::class.java)
    }
}