package com.test.libraries
import java.util.*


class DateWithLabel(
    private val label: String,
    private val date: Date
) {
    init {
        if(date == null)
            throw IllegalArgumentException("null value provided. label=[$label], date=[$date]")
    }
    override fun toString(): String = label
    override fun hashCode() : Int{
        throw IllegalStateException("Not implemented")
    }
    override fun equals(o : Any?): Boolean{
        val dateHelper = DateHelper()
        if(o is DateWithLabel){
            val newDate = o as DateWithLabel
            return label == newDate.label && dateHelper.compareDateIgnoreTime(date, newDate.date) == 0
        }
        return false
    }


}