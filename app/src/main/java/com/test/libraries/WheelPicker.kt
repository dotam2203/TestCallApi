package com.test.libraries

import android.content.Context
import android.graphics.Paint
import android.os.Handler
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.VelocityTracker
import android.view.View
import android.widget.AdapterView
import android.widget.Scroller
import java.util.*


abstract class WheelPicker<V> constructor(context: Context, attrs: AttributeSet ?= null) : View(context,attrs){
    val SCROLL_STATE_IDLE : Int = 0
    val SCROLL_STATE_DRAGGING : Int = 1
    val SCROLL_STATE_SCROLLING : Int = 2
    val ALIGN_CENTER : Int = 0
    val ALIGN_LEFT : Int = 1
    val ALIGN_RIGHT : Int = 2
    val MAX_ANGLE : Int = 90

    protected val FORMAT: String = "%1$02d"
    protected val dateHelper: DateHelper = DateHelper()
    protected val handle: Handler = Handler()
    protected var defaultValue: V? = null
    protected var lastScrollPosition: Int = 0
    protected var listener: Listener<WheelPicker<*>,V>? = null
    protected var adapter: Adapter<V> = Adapter()

    private var customLocale: Locale ?= null
    private var paint: Paint ?= null
    private var scroller: Scroller ?= null
    private var tracker: VelocityTracker?= null







    /*interface onItemSelectedListener{
        fun onItemSelected(picker: WheelPicker<V>, data: Object, position: Int)
    }*/
    interface BaseAdapter<V>{
        fun getItemCount() : Int
        fun getItem(position: Int): V
        fun getItemText(position: Int): String
    }
    class Adapter<V> constructor(
        private var data: MutableList<V> = mutableListOf()
    ) : BaseAdapter<V>{
        override fun getItemCount(): Int = data.size

        override fun getItem(position: Int): V {
            val itemCount = getItemCount()
            return if(itemCount == 0) {
                null as V
            } else {
                data[(position + itemCount) % itemCount]
            }
        }

        override fun getItemText(position: Int): String {
            return try {
                data[position].toString()
            } catch (t: Throwable){
                ""
            }
        }
        fun getData(): List<V> = data
        fun setData(data : List<V>){
            this.data.apply {
                clear()
                addAll(data)
            }
        }
        fun addData(data: List<V>){
            this.data.addAll(data)
        }
        fun getItemPosition(value: V): Int = data.indexOf(value)

    }
    protected interface Listener<PICKER : WheelPicker<*>, V> {
        fun onSelected(picker: PICKER, position: Int, value: V)
        fun onCurrentScrolled(picker: PICKER, position: Int, value: V)
    }
}