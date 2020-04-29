package com.tsp.learn.android.bestsellerbooks.adapter

import android.view.ContextThemeWrapper
import android.widget.FrameLayout
import androidx.test.core.app.ApplicationProvider
import assertk.assertThat
import assertk.assertions.isInstanceOf
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.tsp.learn.android.bestsellerbooks.R
import com.tsp.learn.android.bestsellerbooks.adapter.viewholder.BookViewHolder
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BookListAdapterTest {

    private val mockEventBus = mock<EventBus>()
    private val mockBook = mock<Book>()
    private val mockBookViewHolder = mock<BookViewHolder>()

    private lateinit var bookListAdapter: BookListAdapter
    private lateinit var context: ContextThemeWrapper

    @Before
    fun setUp() {
        bookListAdapter = BookListAdapter(mockEventBus)
        context = ContextThemeWrapper(ApplicationProvider.getApplicationContext(), R.style.AppTheme)
    }

    @Test
    fun testOnCreateViewHolder() {
        assertThat(bookListAdapter.createViewHolder(FrameLayout(context), 0)).isInstanceOf(BookViewHolder::class.java)
    }

    @Test
    fun testOnBindViewHolder() {
        bookListAdapter.submitList(listOf(mockBook))

        bookListAdapter.onBindViewHolder(mockBookViewHolder, 0)

        verify(mockBookViewHolder).bind(mockBook, mockEventBus)
    }
}