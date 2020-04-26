package com.tsp.learn.android.bestsellerbooks.data.model

data class Book (val isbn:String,
                 val rank: Int,
                 val description: String,
                 val author:String,
                 val amazonUrl:String,
                 var coverUrl:String )