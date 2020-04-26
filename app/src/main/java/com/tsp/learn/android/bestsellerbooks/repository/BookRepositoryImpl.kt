package com.tsp.learn.android.bestsellerbooks.repository

import com.tsp.learn.android.bestsellerbooks.repository.service.BookService
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import com.tsp.learn.android.bestsellerbooks.mapper.BookMapper
import com.tsp.learn.android.bestsellerbooks.utils.Constants
import io.reactivex.Observable
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val bookService: BookService) :
    BookRepository {

    override fun retrieveHardCoverFictionBooks(): Observable<List<Book>> {
        return bookService.getHardCordFictionBooks(Constants.API_KEY)
            .flatMap { response -> Observable.just(BookMapper.apply(response)) }
    }
}