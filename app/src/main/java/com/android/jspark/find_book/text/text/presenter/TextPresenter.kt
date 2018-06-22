package com.android.jspark.find_book.text.text.presenter

import android.util.Log
import android.widget.Toast
import com.android.jspark.find_book.BooksData
import com.android.jspark.find_book.data.naver.NaverRepository
import com.android.jspark.find_book.text.TextFragment
import com.android.jspark.find_book.text.adapter.BooksRecyclerAdapter
import com.android.jspark.find_book.text.adapter.model.BookRecyclerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.experimental.coroutineContext

/**
 * Created by js_park on 2018-06-11.
 */

class TextPresenter (val view : TextContract.View,
                    val naverRepository : NaverRepository,
                    val bookRecyclerModel : BookRecyclerModel) : TextContract.Presenter{

    private val tag : String = "TextPresenter"

    override fun searchData(bookName : String)
    {
        view.showProgress()
        //여기서 bookName을 Async 태우고 모델의 데이터에 리턴..!!
        naverRepository.getBooksData(bookName)
                .enqueue(object : Callback<BooksData>{

                    override fun onFailure(call : Call<BooksData>? , t : Throwable?)
                    {
                        view.hideProgress()
                        view.showLoadFail("서버 API 오류")
                    }

                    override fun onResponse(call : Call<BooksData>? , response : Response<BooksData>?)
                    {
                        bookRecyclerModel.clear()
                        if(response?.isSuccessful == true)
                        {
                            response.body().takeIf { it!!.items.size > 0 }?.let {
                                //성공시
                                response.body()!!.items.forEach {
                                //API로부터 받은 Data를 RecyclerView로 출력
                                    //TODO(1) 이미지 처리 할 것 (URL을 통하여 이미지 출력) -> glidde를 활용하여 확인..!!
                                    //TODO(2) title의 태그값 제거 -> 정규표현식?
                                    Log.d("${tag}_ITEMS", it.title)
                                    Log.d("${tag}Images", it.image)
                                    bookRecyclerModel.addItem(it)
                                }
                            } ?:let {
                                //정상적인 처리지만 에러발생시
                                view.showLoadFail("없는 책 입니다.")
                            }
                        } else {
                            view.showLoadFail("다시 검색하여 주세요")
                        }
                        bookRecyclerModel.notifyDataSetChange()
                        view.hideProgress()
                    }
                })
    }
}