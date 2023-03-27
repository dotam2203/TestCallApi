package com.test.libraries

import java.util.*

class DateHelper{
    private var timeZone: TimeZone = TimeZone.getDefault()
    constructor(){
        timeZone = TimeZone.getDefault()
    }
    constructor(timeZone: TimeZone){
        this.timeZone = timeZone
    }
    fun setTimeZone(timeZoneValue: TimeZone){
        timeZone = timeZoneValue
    }
    //trả về số lượng timezone
    fun getTimeZon(): TimeZone = timeZone ?: TimeZone.getDefault()
    private fun getCalendarOfDate(date: Date) : Calendar{
        val calendar: Calendar = Calendar.getInstance(getTimeZon())
        calendar.apply {
            time = date
            set(Calendar.MILLISECOND,0)
            set(Calendar.SECOND,0)
        }
        return calendar
    }
    fun today() : Date{
        val now : Calendar = Calendar.getInstance(getTimeZon())
        return now.time
    }
    fun getMonth(date: Date) : Int = getCalendarOfDate(date).get(Calendar.MONTH)
    fun getDay(date: Date) : Int = getCalendarOfDate(date).get(Calendar.DAY_OF_MONTH)
    private fun getZeroTimeDateWithoutTimeZone(date : Date) : Date{
        val calendar : Calendar = Calendar.getInstance()
        calendar.apply {
            time = date
            set(Calendar.HOUR_OF_DAY,0)
            set(Calendar.MINUTE,0)
            set(Calendar.SECOND,0)
            set(Calendar.MILLISECOND,0)
        }
        return calendar.time
    }
    fun compareDateIgnoreTime(first: Date, second: Date) : Int{
        val firstZeroTime = getZeroTimeDateWithoutTimeZone(first)
        val secondZeroTime = getZeroTimeDateWithoutTimeZone(second)
        return firstZeroTime.compareTo(secondZeroTime)
    }

}
