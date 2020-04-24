package com.tsp.learn.android.bestsellerbooks

import com.tsp.learn.android.bestsellerbooks.contract.HomeContract
import com.tsp.learn.android.bestsellerbooks.mvp.RxBaseMvpPresenter

class HomeActivityPresenter : RxBaseMvpPresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun loadBestSellerBooks() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}