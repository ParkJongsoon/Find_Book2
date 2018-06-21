package com.android.jspark.find_book.network

import com.android.jspark.find_book.BooksData
import com.android.jspark.find_book.data.naver.NaverDataSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by js_park on 2018-06-19.
 */

interface ServiceInterface {

    @Headers(
            "X-Naver-Client-ID: GevOMEXRGwrk2_XTHM7r",
            "X-Naver-Client-Secret: HCwPRnA7pM"
    )
    @GET("v1/search/book.json")
    fun getBooksData(
            @Query("query") bookName : String
    ) : Call<BooksData>
}