package com.tsp.learn.android.bestsellerbooks

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.tsp.learn.android.bestsellerbooks.contract.HomeContract
import javax.inject.Inject

class HomeActivity : MvpActivity<HomeContract.View, HomeContract.Presenter>() {

    @Inject
    lateinit var homeActivityPresenter: HomeActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createPresenter(): HomeContract.Presenter = homeActivityPresenter
}
