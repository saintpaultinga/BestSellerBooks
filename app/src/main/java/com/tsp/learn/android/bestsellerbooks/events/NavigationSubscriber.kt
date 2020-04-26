package com.tsp.learn.android.bestsellerbooks.events

interface NavigationSubscriber {
    fun navigateToBookCheckout(event: NavigateToAmazonEvent)
}
data class NavigateToAmazonEvent (val bookUrl: String)