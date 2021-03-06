package com.android.jspark.find_book.Util

import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import retrofit2.Retrofit

/**
 * Created by js_park on 2018-06-12.
 */

fun AppCompatActivity.replace(@IdRes frameId : Int, fragment : android.support.v4.app.Fragment, tag : String? = null )
{
    supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()
}
