package com.android.jspark.find_book.data.naver

import com.android.jspark.find_book.BooksData
import retrofit2.Call

/**
 * Created by js_park on 2018-06-21.
 */

interface NaverDataSource {
    fun getBooksData( bookname : String ) : Call<BooksData>
}