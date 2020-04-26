package com.tsp.learn.android.bestsellerbooks

import com.nhaarman.mockitokotlin2.*
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import com.tsp.learn.android.bestsellerbooks.events.NavigateToAmazonEvent
import com.tsp.learn.android.bestsellerbooks.repository.BookRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeActivityPresenterTest {

    private val mockRepository = mock<BookRepository>()
    private val mockEventBus = mock<EventBus>()
    private val mockNavigateToAmazonEvent = mock<NavigateToAmazonEvent>()
    private val mockView = mock<HomeActivity>()

    private lateinit var homeActivityPresenter: HomeActivityPresenter

    @Before
    fun setUp() {
        homeActivityPresenter = HomeActivityPresenter(mockRepository, mockEventBus)
    }

    @Test
    fun testNavigateToBookCheckout() {
        homeActivityPresenter.attachView(mockView)
        doReturn(FAKE_BOOK_URL).whenever(mockNavigateToAmazonEvent).bookUrl

        homeActivityPresenter.navigateToBookCheckout(mockNavigateToAmazonEvent)

        verify(mockView).navigateToBookCheckoutPage(FAKE_BOOK_URL)
        verify(mockNavigateToAmazonEvent).bookUrl
    }

    @Test
    fun testLoadBestSellerBooks() {
        homeActivityPresenter = spy(homeActivityPresenter)
        homeActivityPresenter.attachView(mockView)
        doReturn(Observable.just(demandBooks())).whenever(mockRepository).retrieveHardCoverFictionBooks()
        doReturn(Observable.just(demandBooks())).whenever(homeActivityPresenter).bind(any<Observable<List<Book>>>())
        doReturn(Schedulers.trampoline()).whenever(homeActivityPresenter).io()

        homeActivityPresenter.loadBestSellerBooks()

        verify(mockView).onBooksLoaded(demandBooks())
        verify(mockRepository).retrieveHardCoverFictionBooks()
        verify(homeActivityPresenter).io()
        verify(homeActivityPresenter).ui()
        verify(homeActivityPresenter).bind(any<Observable<List<Book>>>())
    }

    private fun demandBooks(): List<Book> {
        val list = mutableListOf<Book>()
        list.add(
            Book("123",
            1,
            "talk about vampires",
            "John", FAKE_BOOK_URL, FAKE_BOOK_URL)
        )
        return list
    }

    private companion object {
        private const val FAKE_BOOK_URL = "https://amazon/books/isbn/url?imageId"
    }
}