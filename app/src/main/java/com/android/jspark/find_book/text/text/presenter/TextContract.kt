package com.android.jspark.find_book.text.text.presenter

/**
 * Created by js_park on 2018-06-11.
 */

interface TextContract {

    interface View {
        fun showData()
        fun hideProgress()
        fun showProgress()
        fun showLoadFail( errorMessage : String)
    }

    interface Presenter{
        fun searchData(bookName : String)
    }
}