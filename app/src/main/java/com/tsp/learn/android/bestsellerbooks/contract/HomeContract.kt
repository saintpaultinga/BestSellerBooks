package com.tsp.learn.android.bestsellerbooks.contract

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.tsp.learn.android.bestsellerbooks.model.Books

interface HomeContract {
    interface View : MvpView {
        /**
         * @param bookList the list of books to be displayed
         */
        fun onBooksLoaded(bookList:List<Books>)

        /**
         * @param book refresh the current book from the list
         * called to update the book cover image.
         */
        fun updateBookCover(book: Books)
    }

    interface Presenter : MvpPresenter<View> {
        /**
         * load all the best seller books from New York Times
         */
        fun loadBestSellerBooks()
    }
}