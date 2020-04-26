package com.tsp.learn.android.bestsellerbooks.mapper

import com.tsp.learn.android.bestsellerbooks.data.entities.BookEntity
import com.tsp.learn.android.bestsellerbooks.data.entities.BookResponse
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import java.util.function.Function

object BookMapper : Function<BookResponse, List<Book>> {

    override fun apply(response: BookResponse): List<Book> = map(response)

    private fun map(response: BookResponse): List<Book> =
        response.entry.bookList.map { bookEntity -> mapToModel(bookEntity) }

    private fun mapToModel(bookEntity: BookEntity): Book =
        Book(
            bookEntity.isbn,
            bookEntity.rank,
            bookEntity.desc,
            bookEntity.author,
            bookEntity.amazonUrl,
            bookEntity.coverUrl
        )
}