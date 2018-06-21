package com.android.jspark.find_book.data.naver

import com.android.jspark.find_book.BooksData
import com.android.jspark.find_book.network.ServiceInterface
import com.android.jspark.find_book.network.createRetrofit
import retrofit2.Call

/**
 * Created by js_park on 2018-06-21.
 */

class NaverRemoteData : NaverDataSource {

    companion object
    {
        const val NAVER_URL = "https://openapi.naver.com/"
    }

    private val naverServiceInterface = createRetrofit(ServiceInterface::class.java, NAVER_URL)

    override fun getBoosData(bookname : String) = naverServiceInterface.getBooksData(bookname)
}