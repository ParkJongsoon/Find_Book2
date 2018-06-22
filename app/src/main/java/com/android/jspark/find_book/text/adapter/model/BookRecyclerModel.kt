package com.android.jspark.find_book.text.adapter.model

import com.android.jspark.find_book.BooksData
import com.android.jspark.find_book.book

/**
 * Created by js_park on 2018-06-22.
 */

interface BookRecyclerModel {

    fun addItem(item : book)

    fun getItemCount() : Int

    fun notifyDataSetChange()

    fun clear()
}