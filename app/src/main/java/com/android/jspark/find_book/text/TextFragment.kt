package com.android.jspark.find_book.text

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.android.jspark.find_book.R
import com.android.jspark.find_book.data.naver.NaverRepository
import com.android.jspark.find_book.text.adapter.BooksRecyclerAdapter
import com.android.jspark.find_book.text.text.presenter.TextContract
import com.android.jspark.find_book.text.text.presenter.TextPresenter
import kotlinx.android.synthetic.main.fragment_text.*
import kotlinx.android.synthetic.main.fragment_text.view.*


class TextFragment : Fragment(), TextContract.View
{
    private lateinit var btn_search : Button
    private lateinit var edt_search : EditText
    private lateinit var progressBar : ProgressBar

    private val textPresenter : TextPresenter by lazy {
        TextPresenter(this, NaverRepository, bookRecyclerAdapter)
    }

    private val bookRecyclerAdapter : BooksRecyclerAdapter by lazy {
        BooksRecyclerAdapter(this@TextFragment.context)
    }

    override fun showLoadFail( errorMessage : String)
    {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgress()
    {
        progressBar.visibility = View.GONE
    }

    override fun showProgress()
    {
        progressBar.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater : LayoutInflater? , container : ViewGroup? , savedInstanceState : Bundle?) : View?
    {
        var view : View = inflater?.inflate(R.layout.fragment_text , container , false) as View

        btn_search = view.findViewById(R.id.btn_search) as Button
        edt_search = view.findViewById(R.id.edt_search) as EditText
        progressBar = view.findViewById(R.id.progressBar) as ProgressBar


        view.recyclerView.run {
            adapter = bookRecyclerAdapter
            layoutManager  = LinearLayoutManager(this@TextFragment.context)
        }


        btn_search.setOnClickListener {

            if(edt_search.text.toString().isNullOrBlank()){
                showLoadFail("검색어를 입력하세요")
            }

            else {
                textPresenter.searchData(edt_search.text.toString())
            }
        }
        return view
    }
}
