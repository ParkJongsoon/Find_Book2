package com.android.jspark.find_book

/**
 * Created by js_park on 2018-06-21.
 */
data class BooksData(
        val lastBuildDate: String,
        val total: Int,
        val start: Int,
        val display: Int,
        val items: List<Item>
)