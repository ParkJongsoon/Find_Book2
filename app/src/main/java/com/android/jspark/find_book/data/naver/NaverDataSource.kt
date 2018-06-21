package com.android.jspark.find_book.data.naver

import com.android.jspark.find_book.BooksData
import com.android.jspark.find_book.Item
import retrofit2.Call

/**
 * Created by js_park on 2018-06-21.
 */

interface NaverDataSource {
    fun getBoosData( bookname : String ) : Call<BooksData>
}