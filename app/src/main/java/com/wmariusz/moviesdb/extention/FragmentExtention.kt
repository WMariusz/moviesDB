package com.wmariusz.moviesdb.extention

import android.support.v4.app.Fragment
import android.widget.Toast

fun Fragment.toast(text: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(context, text, duration).show()