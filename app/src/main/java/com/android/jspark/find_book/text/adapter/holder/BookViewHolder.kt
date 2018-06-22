package com.android.jspark.find_book.text.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.jspark.find_book.R
import com.android.jspark.find_book.book
import kotlinx.android.synthetic.main.book_item_view.view.*

/**
 * Created by js_park on 2018-06-21.
 */

class BookViewHolder ( context : Context , parent : ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.book_item_view, parent, false)){

    fun onBind ( item : book) {
        itemView.onBind(item)
    }

    private fun View.onBind(item : book) {
        //여기서 onBind를 실행
        bookTitle.setText(item.title)
    }
}