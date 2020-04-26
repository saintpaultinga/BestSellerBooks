package com.tsp.learn.android.bestsellerbooks.repository

import com.tsp.learn.android.bestsellerbooks.data.model.Book
import io.reactivex.Observable

interface BookRepository {
    /**
     * get the hardcover fiction books
     * @return an observable of BookResponse
     */
    fun retrieveHardCoverFictionBooks(): Observable<List<Book>>
}