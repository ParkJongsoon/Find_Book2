package com.android.jspark.find_book.text.text.presenter

import android.util.Log
import android.widget.Toast
import com.android.jspark.find_book.BooksData
import com.android.jspark.find_book.data.naver.NaverRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by js_park on 2018-06-11.
 */

class TextPresenter (val view : TextContract.View, val naverRepository : NaverRepository) : TextContract.Presenter{

    private val tag : String = "TextPresenter"

    override fun loadData()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun searchData(bookName : String)
    {
        Log.d("TextPresenter",bookName)
        //여기서 bookName을 Async 태우고 모델의 데이터에 리턴..!!
        naverRepository.getBoosData(bookName)
                .enqueue(object : Callback<BooksData>{
                    override fun onFailure(call : Call<BooksData>? , t : Throwable?)
                    {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call : Call<BooksData>? , response : Response<BooksData>?)
                    {
                        Log.d("ONRESPONSE","FINISH")
                    }
                })
    }
}