package com.wmariusz.moviesdb.extention

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.replaceFragment(@IdRes containerId: Int, fragment: Fragment, addToBackStack: Boolean = false) =
        with(supportFragmentManager.beginTransaction()) {
            replace(containerId, fragment)
            if (addToBackStack) {
                addToBackStack(fragment.javaClass.simpleName)
            }
            commit()
        }