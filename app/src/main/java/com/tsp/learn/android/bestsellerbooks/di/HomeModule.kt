package com.tsp.learn.android.bestsellerbooks.di

import com.tsp.learn.android.bestsellerbooks.HomeActivityPresenter
import com.tsp.learn.android.bestsellerbooks.contract.HomeContract
import com.tsp.learn.android.bestsellerbooks.repository.service.BookService
import com.tsp.learn.android.bestsellerbooks.repository.BookRepository
import com.tsp.learn.android.bestsellerbooks.repository.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton

@Module(includes = [RestModule::class])
class HomeModule {

    @Provides
    @Singleton
    fun provideHomePresenter(bookRepository: BookRepository, eventBus: EventBus): HomeContract.Presenter =
        HomeActivityPresenter(bookRepository, eventBus)

    @Provides
    @Singleton
    fun provideBookRepository(bookService: BookService): BookRepository = BookRepositoryImpl(bookService)

    @Provides
    @Singleton
    fun provideEventBus(): EventBus = EventBus.getDefault()
}