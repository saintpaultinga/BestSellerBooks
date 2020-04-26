package com.tsp.learn.android.bestsellerbooks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.tsp.learn.android.bestsellerbooks.R
import com.tsp.learn.android.bestsellerbooks.adapter.viewholder.BookViewHolder
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import org.greenrobot.eventbus.EventBus

class BookListAdapter(private val event: EventBus) : ListAdapter<Book, BookViewHolder>(BookDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
       BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, event)
    }

}