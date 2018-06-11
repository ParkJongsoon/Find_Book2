package com.android.jspark.find_book

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.jspark.find_book.text.TextFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.android.jspark.find_book.Util.replace


class MainActivity : AppCompatActivity()
{

    private val textFragment : TextFragment by lazy {
        TextFragment()
    }

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace(R.id.container, textFragment)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId)
        {
            R.id.navigation_search ->
            {
                replace(R.id.container, textFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_scan->
            {
                Toast.makeText(this,"on Scan menu click_준비중", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_info ->
            {
                Toast.makeText(this,"on Info menu click_준비중", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
