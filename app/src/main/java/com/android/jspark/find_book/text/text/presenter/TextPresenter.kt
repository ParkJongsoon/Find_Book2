package com.android.jspark.find_book.text.text.presenter

import android.util.Log
import android.widget.Toast

/**
 * Created by js_park on 2018-06-11.
 */

class TextPresenter (val view : TextContract.View) : TextContract.Presenter{

    private val tag : String = "TextPresenter"

    override fun loadData()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun searchData(bookName : String)
    {
        Log.d("TextPresenter",bookName)
    }
}