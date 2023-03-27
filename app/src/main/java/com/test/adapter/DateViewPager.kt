package com.test.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.viewpager.widget.PagerAdapter

class DateViewPager(
    private val context: Context
) : PagerAdapter(){
    private val calendarViews = arrayOf(
        CalendarView(context),
        CalendarView(context),
        CalendarView(context)
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(calendarViews[position])
        return calendarViews[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
    override fun getCount(): Int = calendarViews.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

}