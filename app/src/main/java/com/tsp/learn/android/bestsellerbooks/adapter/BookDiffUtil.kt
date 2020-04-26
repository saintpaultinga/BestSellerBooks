package com.tsp.learn.android.bestsellerbooks.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tsp.learn.android.bestsellerbooks.data.model.Book
import java.util.*

class BookDiffUtil : DiffUtil.ItemCallback<Book>() {
    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean =
        Objects.equals(oldItem, newItem)

    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean =
        oldItem.isbn == newItem.isbn
}