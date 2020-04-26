package com.tsp.learn.android.bestsellerbooks.adapter.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tsp.learn.android.bestsellerbooks.R
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import com.tsp.learn.android.bestsellerbooks.events.NavigateToAmazonEvent
import org.greenrobot.eventbus.EventBus

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val authorTxV = itemView.findViewById<TextView>(R.id.book_item_author)
    private val descTxV = itemView.findViewById<TextView>(R.id.book_item_desc_content)
    private val coverImageView = itemView.findViewById<ImageView>(R.id.book_item_image)
    private var bookAmazonUrl = ""
    private var eventBus: EventBus? = null

    init {
        ButterKnife.bind(this, itemView)
    }

    fun bind(book: Book, eventBus: EventBus) {
        displayData(book)
        loadImage(book.coverUrl)
        bookAmazonUrl = book.amazonUrl
        this.eventBus = eventBus
    }

   private fun displayData(book: Book) {
        authorTxV.text = book.author
        descTxV.text = book.description
    }

    private fun loadImage(url: String) {
        // TODO create an imageLoader singleton class and inject it here and use it to load images
        Glide.with(itemView.context).load(url)
            .crossFade()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(coverImageView)
    }

    @OnClick(R.id.buy_btn)
    fun onBuyBtnClicked(view: View) {
        if (bookAmazonUrl.isNotEmpty()) {
            eventBus?.post(NavigateToAmazonEvent(bookAmazonUrl))
        }
    }
}