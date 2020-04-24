package com.tsp.learn.android.bestsellerbooks.di

import com.tsp.learn.android.bestsellerbooks.HomeActivityPresenter
import com.tsp.learn.android.bestsellerbooks.contract.HomeContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeModule {

    @Provides
    @Singleton
    fun provideHomePresenter(): HomeContract.Presenter = HomeActivityPresenter()
}