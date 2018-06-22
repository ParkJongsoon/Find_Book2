package com.android.jspark.find_book.data.naver

import com.android.jspark.find_book.BooksData
import retrofit2.Call

/**
 * Created by js_park on 2018-06-21.
 */

object NaverRepository : NaverDataSource {

    private val naverRemoteData = NaverRemoteData()

    override fun getBooksData(bookname : String) = naverRemoteData.getBooksData(bookname)

}