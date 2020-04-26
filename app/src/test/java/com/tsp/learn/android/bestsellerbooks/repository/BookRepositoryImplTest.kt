package com.tsp.learn.android.bestsellerbooks.repository

import com.nhaarman.mockitokotlin2.mock
import com.tsp.learn.android.bestsellerbooks.repository.service.BookService
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class BookRepositoryImplTest {

    private val mockBookService = mock<BookService>()
    private lateinit var bookRepository: BookRepository

    @Before
    fun setUp() {
        bookRepository = BookRepositoryImpl(mockBookService)
    }

    @Test
    fun retrieveHardCoverFictionBooks() {

        bookRepository.retrieveHardCoverFictionBooks()
    }

    private fun demandBookResponse() {

    }
}