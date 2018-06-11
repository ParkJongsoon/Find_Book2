package com.android.jspark.find_book.text

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.android.jspark.find_book.R
import com.android.jspark.find_book.text.text.presenter.TextContract
import com.android.jspark.find_book.text.text.presenter.TextPresenter
import kotlinx.android.synthetic.main.fragment_text.*


class TextFragment : Fragment(), TextContract.View
{
    private lateinit var btn_search : Button
    private lateinit var edt_search : EditText

    private val textPresenter : TextPresenter by lazy {
        TextPresenter(this)
    }

    override fun showData()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

        btn_search.setOnClickListener {

            if(edt_search.text.toString().isNullOrBlank()){
                Toast.makeText(context, "검색어를 입력하세요" , Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(context, edt_search.text.toString() , Toast.LENGTH_SHORT).show()
                textPresenter.searchData(edt_search.text.toString())
            }
        }

        return view
    }
}
