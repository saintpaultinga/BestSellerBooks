package com.tsp.learn.android.bestsellerbooks.contract

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.tsp.learn.android.bestsellerbooks.data.model.Book

interface HomeContract {
    interface View : MvpView {
        /**
         * @param bookList the list of books to be displayed
         */
        fun onBooksLoaded(bookList:List<Book>?)

        /**
         * @param bookUrl used to navigate to the book amazon page
         *
         */
        fun navigateToBookCheckoutPage(bookUrl: String)

        /**
         * show error when an issue happens during the data loading
         */
        fun showError()
    }

    interface Presenter : MvpPresenter<View> {
        /**
         * load all the best seller books from New York Times
         */
        fun loadBestSellerBooks()
    }
}