package com.android.jspark.find_book.text.text.presenter

import android.util.Log
import android.widget.Toast
import com.android.jspark.find_book.BooksData
import com.android.jspark.find_book.data.naver.NaverRepository
import com.android.jspark.find_book.text.TextFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.experimental.coroutineContext

/**
 * Created by js_park on 2018-06-11.
 */

class TextPresenter (val view : TextContract.View, val naverRepository : NaverRepository) : TextContract.Presenter{

    private val tag : String = "TextPresenter"

    override fun searchData(bookName : String)
    {
        view.showProgress()
        //여기서 bookName을 Async 태우고 모델의 데이터에 리턴..!!
        naverRepository.getBoosData(bookName)
                .enqueue(object : Callback<BooksData>{

                    override fun onFailure(call : Call<BooksData>? , t : Throwable?)
                    {
                        view.hideProgress()
                        view.showLoadFail("서버 API 오류")
                    }

                    override fun onResponse(call : Call<BooksData>? , response : Response<BooksData>?)
                    {
                        if(response?.isSuccessful == true)
                        {
                            response.body().takeIf { it!!.items.size > 0 }?.let {
                                //성공시
                                response.body()!!.items.forEach {
                                    Log.d("ITEMS", it.title)
                                }
                            } ?:let {
                                //정상적인 처리지만 에러발생시
                                view.showLoadFail("없는 책 입니다.")
                            }
                        } else {
                            view.showLoadFail("다시 검색하여 주세요")
                        }
                        view.hideProgress()
                    }
                })
    }
}