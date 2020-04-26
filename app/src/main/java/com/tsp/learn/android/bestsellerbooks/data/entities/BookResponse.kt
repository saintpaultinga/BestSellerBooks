package com.tsp.learn.android.bestsellerbooks.data.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class BookResponse (@JsonProperty("results") val entry: BookEntry)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class BookEntry(@JsonProperty("books") val bookList: List<BookEntity>)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class BookEntity(@JsonProperty("primary_isbn10") val isbn: String,
           @JsonProperty("rank") val rank: Int,
           @JsonProperty("title") val tile: String,
           @JsonProperty("author") val author: String,
           @JsonProperty("description") val desc: String,
           @JsonProperty("book_image") val coverUrl: String,
           @JsonProperty("amazon_product_url") val amazonUrl: String)