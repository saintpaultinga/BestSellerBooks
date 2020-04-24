package com.tsp.learn.android.bestsellerbooks.model

data class Books (val isbn:Int,
                  val title:String,
                  val description: String,
                  val author:String,
                  val amazonUrl:String,
                  var coverUrl:String = "")