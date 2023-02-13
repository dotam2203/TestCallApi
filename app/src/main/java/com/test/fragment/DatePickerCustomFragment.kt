package com.test.fragment

import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder.customDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import com.test.R
import com.test.databinding.FragmentDatePickerCustomeBinding
import java.text.SimpleDateFormat
import java.util.*

class DatePickerCustomFragment : Fragment() {
    private lateinit var binding: FragmentDatePickerCustomeBinding
    private val formatDate = SimpleDateFormat("dd/MM/YYYY")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDatePickerCustomeBinding.inflate(layoutInflater)
        binding.outputDate.setOnClickListener {
            CustomDatePicker()
        }
        return binding.root
    }
    private fun CustomDatePicker(){
        val calendar : Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(requireContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val selectDate = GregorianCalendar(year, month, dayOfMonth).time
            //val selectDate = Calendar.getInstance()
            /*selectDate.apply {
                set(Calendar.YEAR,year)
                set(Calendar.MONTH,month)
                set(Calendar.DAY_OF_MONTH,dayOfMonth)
            }*/
            val date = formatDate.format(selectDate.time)
            binding.outputDate.text = date
        },year,month,day)
        datePickerDialog.datePicker.apply {
            //date gone
            /*findViewById<View>(Resources.getSystem().getIdentifier("day","id","android")).visibility = View.GONE
            findViewById<View>(Resources.getSystem().getIdentifier("month","id","android")).visibility = View.GONE
            findViewById<View>(Resources.getSystem().getIdentifier("year","id","android")).visibility = View.GONE*/

            //data visibility

        }

        datePickerDialog.show()

    }
}