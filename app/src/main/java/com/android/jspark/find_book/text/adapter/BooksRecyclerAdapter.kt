package com.android.jspark.find_book.text.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.android.jspark.find_book.book
import com.android.jspark.find_book.text.adapter.holder.BookViewHolder
import com.android.jspark.find_book.text.adapter.model.BookRecyclerModel

/**
 * Created by js_park on 2018-06-21.
 */

class BooksRecyclerAdapter(private val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), BookRecyclerModel {

    private val booklist = mutableListOf<book>()

    override fun onCreateViewHolder(parent : ViewGroup? , viewType : Int) : RecyclerView.ViewHolder
    {
        return BookViewHolder(context, parent)
    }

    override fun onBindViewHolder(holder : RecyclerView.ViewHolder? , position : Int)
    {
        //홀더가 넘어오면 홀더를 체크하여 onBind를 Call하도록
        (holder as? BookViewHolder) ?. onBind(booklist[position])
    }

    override fun getItemCount() : Int = booklist.size

    override fun addItem(item : book)
    {
        booklist.add(item)
    }

    override fun clear()
    {
        booklist.clear()
    }

    override fun notifyDataSetChange()
    {
        notifyDataSetChanged()
    }

}
