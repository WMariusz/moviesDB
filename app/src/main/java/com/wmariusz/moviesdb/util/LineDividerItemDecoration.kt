package com.wmariusz.moviesdb.util

import android.content.Context
import android.graphics.Canvas
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView


class LineDividerItemDecoration(context: Context, @DrawableRes drawableRes: Int) : RecyclerView.ItemDecoration() {

    private val divider = ContextCompat.getDrawable(context, drawableRes)!!

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.getIntrinsicHeight()

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }
}