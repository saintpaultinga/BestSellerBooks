package com.tsp.learn.android.bestsellerbooks.di

import android.app.Application
import com.tsp.learn.android.bestsellerbooks.BookApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityBindingModule::class, ApplicationModule::class, HomeModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<BookApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}