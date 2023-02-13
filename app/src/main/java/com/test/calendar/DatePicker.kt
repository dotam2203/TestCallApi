package com.test.calendar

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import java.util.*

class DatePicker: DialogFragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var date: Date

    interface Callbacks {
        fun onDateSelected(date: Date)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        date = arguments?.getSerializable(ARG_DATE) as Date
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance().apply {
            time = date
        }

        val initialYear = calendar.get(Calendar.YEAR)
        val initialMonth = calendar.get(Calendar.MONTH)
        val initialDay = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            requireContext(),
            this,
            initialYear,
            initialMonth,
            initialDay
        )
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = GregorianCalendar(year, month, dayOfMonth).time
        targetFragment?.let { fragment ->
            (fragment as Callbacks).onDateSelected(selectedDate)
        }
    }

    companion object {
        fun getInstance(date: Date): com.test.calendar.DatePicker {
            return DatePicker().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_DATE, date)
                }
            }
        }
    }
}

private const val ARG_DATE = "date"