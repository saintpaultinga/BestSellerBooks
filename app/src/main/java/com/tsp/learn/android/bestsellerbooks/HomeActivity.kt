package com.tsp.learn.android.bestsellerbooks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.tsp.learn.android.bestsellerbooks.adapter.BookListAdapter
import com.tsp.learn.android.bestsellerbooks.contract.HomeContract
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject
// TODO add unit test to cover this activity
class HomeActivity : MvpActivity<HomeContract.View, HomeContract.Presenter>(), HomeContract.View {

    @BindView(R.id.book_list)
    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var eventBus: EventBus

    @Inject
    lateinit var homeActivityPresenter: HomeContract.Presenter

    private lateinit var bookLisAdapter: BookListAdapter

    init {
        BookApplication.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        bookLisAdapter = BookListAdapter(eventBus)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
        }

        recyclerView.adapter = bookLisAdapter

        // TODO add code to show loading status here, use a circular progress indicator
    }

    override fun onStart() {
        super.onStart()
        homeActivityPresenter.loadBestSellerBooks()
    }

    override fun createPresenter(): HomeContract.Presenter = homeActivityPresenter

    override fun onBooksLoaded(bookList: List<Book>?) {
        bookLisAdapter.submitList(bookList)
    }

    override fun navigateToBookCheckoutPage(bookUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(bookUrl)
        startActivity(intent)
    }

    override fun showError() {
        // TODO replace by a custom error view
        Toast.makeText(this, R.string.error_msg, Toast.LENGTH_SHORT).show()
    }

}
