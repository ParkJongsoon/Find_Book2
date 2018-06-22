package com.android.jspark.find_book

/**
 * Created by js_park on 2018-06-21.
 */
data class BooksData(
        val lastBuildDate: String,
        val total: Int,
        val start: Int,
        val display: Int,
        val items: List<book>
)

data class book(
        val title: String,
        val link: String,
        val image: String,
        val author: String,
        val price: String,
        val discount: String,
        val publisher: String,
        val pubdate: String,
        val isbn: String,
        val description: String
)