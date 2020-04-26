package com.tsp.learn.android.bestsellerbooks.di

import android.content.Context
import com.tsp.learn.android.bestsellerbooks.BookApplication
import com.tsp.learn.android.bestsellerbooks.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    HomeModule::class])
interface AppComponent {

    fun inject(application: BookApplication)

    fun inject(mainActivity: HomeActivity)

}