package com.tsp.learn.android.bestsellerbooks.repository

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.tsp.learn.android.bestsellerbooks.data.entities.BookEntity
import com.tsp.learn.android.bestsellerbooks.data.entities.BookEntry
import com.tsp.learn.android.bestsellerbooks.data.entities.BookResponse
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import com.tsp.learn.android.bestsellerbooks.mapper.BookMapper
import com.tsp.learn.android.bestsellerbooks.repository.service.BookService
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString

class BookRepositoryImplTest {

    private val mockBookService = mock<BookService>()
    private lateinit var bookRepository: BookRepository

    @Before
    fun setUp() {
        bookRepository = BookRepositoryImpl(mockBookService)
    }

    @Test
    fun retrieveHardCoverFictionBooks() {
        doReturn(Observable.just(demandBookResponse())).whenever(mockBookService).getHardCordFictionBooks(anyString())
        val testObserver = TestObserver<List<Book>>()

        val observable = bookRepository.retrieveHardCoverFictionBooks()
        observable.subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue(BookMapper.apply(demandBookResponse()))
    }

    private fun demandBookResponse(): BookResponse =
        BookResponse(BookEntry(listOf(BookEntity("12342", 1, "The Widow", "Joshua",
            "How the woman survive along", "https://fake/url", "https://fake/amazon/url"))))

}