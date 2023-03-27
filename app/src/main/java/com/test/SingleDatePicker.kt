package com.test

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.test.librariesjava.*

class SingleDatePicker(context: Context,attrs: AttributeSet) : LinearLayout(context,attrs){
    private var yearPicker: WheelYearPicker ?= null
    private var monthPicker: WheelMonthPicker ?= null
    private var dayOfMonthPicker: WheelDayOfMonthPicker ?= null
    private var dayPicker: WheelDayPicker ?= null
    private var picker: MutableList<WheelPicker<*>> = ArrayList()

    private var dtSelector: View ?= null
    private var mustBeOnFuture: Boolean ?= false

}