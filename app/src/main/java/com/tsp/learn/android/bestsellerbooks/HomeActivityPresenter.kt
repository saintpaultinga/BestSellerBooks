package com.tsp.learn.android.bestsellerbooks

import android.annotation.SuppressLint
import android.util.Log
import com.tsp.learn.android.bestsellerbooks.contract.HomeContract
import com.tsp.learn.android.bestsellerbooks.di.SchedulerProvider
import com.tsp.learn.android.bestsellerbooks.events.NavigateToAmazonEvent
import com.tsp.learn.android.bestsellerbooks.events.NavigationSubscriber
import com.tsp.learn.android.bestsellerbooks.mvp.RxBaseMvpPresenter
import com.tsp.learn.android.bestsellerbooks.repository.BookRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class HomeActivityPresenter @Inject constructor(private val bookRepository: BookRepository,
                                                private val eventBus: EventBus) :
    RxBaseMvpPresenter<HomeContract.View>(), HomeContract.Presenter, NavigationSubscriber, SchedulerProvider {

    override fun attachView(view: HomeContract.View) {
        super.attachView(view)
        eventBus.register(this)
    }

    override fun detachView() {
        super.detachView()
        eventBus.unregister(this)
    }

    @SuppressLint("CheckResult")
    override fun loadBestSellerBooks() {
        // TODO handle network connexion errors
        bind(bookRepository.retrieveHardCoverFictionBooks())
            .subscribeOn(io())
            .observeOn(ui())
            .subscribe({bookResponse ->
            ifViewAttached { view ->
                view.onBooksLoaded(bookResponse)
            }}, this::displayError)
    }

    private fun displayError(error: Throwable) {
        // TODO replace the logging with Timber library and also cover this method with a unit test
        Log.e(this.javaClass.simpleName,"Error loading saves data: ${error.message}")
        ifViewAttached { view ->
            view.showError()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    override fun navigateToBookCheckout(event: NavigateToAmazonEvent) {
        ifViewAttached { view ->
            view.navigateToBookCheckoutPage(event.bookUrl)
        }
    }

    override fun io(): Scheduler = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}