package com.tsp.learn.android.bestsellerbooks.di

import com.tsp.learn.android.bestsellerbooks.HomeActivity
import dagger.Module

@Module
internal interface AppModule {
    fun inject(homeActivity: HomeActivity)
}