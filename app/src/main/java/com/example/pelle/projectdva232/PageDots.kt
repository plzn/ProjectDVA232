package com.example.pelle.projectdva232
import android.content.Context
import android.support.v4.content.ContextCompat
import android.text.Html
import android.widget.LinearLayout
import android.widget.TextView

class PageDots(private var applicationContext: Context, private var linearLayout: LinearLayout) {

    private lateinit var mDots: Array<TextView>

    @Suppress("DEPRECATION")
    fun addDotsIndicator(size: Int) {
        var i = 0

        mDots = Array(size) { TextView (applicationContext) }

        while (i < size) {
            mDots[i].text = Html.fromHtml("&#8226;")
            mDots[i].textSize = 35.0f
            mDots[i].setTextColor(ContextCompat.getColor(applicationContext, R.color.colorTransparentWhite))

            linearLayout.addView(mDots[i])
            i++
        }
    }

    fun setActiveDot(position: Int) {
        for (i in mDots) {
            if (i.currentTextColor == ContextCompat.getColor(applicationContext, R.color.white)) {
                i.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorTransparentWhite))
            }
        }

        if (mDots.isNotEmpty() && mDots.size > position && position >= 0) {
            mDots[position].setTextColor(ContextCompat.getColor(applicationContext, R.color.white))
        }
    }
}