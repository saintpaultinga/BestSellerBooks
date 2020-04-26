package com.tsp.learn.android.bestsellerbooks

import android.app.Application
import com.tsp.learn.android.bestsellerbooks.di.AppComponent
import com.tsp.learn.android.bestsellerbooks.di.DaggerAppComponent
import com.tsp.learn.android.bestsellerbooks.di.RestModule

class BookApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        appComponent = DaggerAppComponent.builder()
            .restModule(RestModule(this))
            .build()
    }

}