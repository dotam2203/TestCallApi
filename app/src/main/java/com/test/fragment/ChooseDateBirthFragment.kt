package com.test.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.test.R
import com.test.databinding.FragmentBirthdayBinding
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class ChooseDateBirthFragment : Fragment() {
    private lateinit var binding: FragmentBirthdayBinding
    private val SPINNER_COUNT = 3
    private val formatDate = SimpleDateFormat("dd/MM/YYYY",Locale.US)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBirthdayBinding.inflate(layoutInflater)
        binding.txtBirthday.setOnClickListener {
            //CustomDatePicker()
            dialogDatePicker()
        }
        return binding.root
    }
    private fun getFragment(fragment: Fragment, id: Int){
        childFragmentManager.beginTransaction().replace(id, fragment).commit()
    }
    private fun getDialogChooseDate() {
        getFragment(DatePickerCustomFragment(), R.id.fragment)
    }

    private fun CustomDatePicker(){
        val calendar : Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(requireContext(), android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val selectDate = GregorianCalendar(year, month, dayOfMonth).time
            //val selectDate = Calendar.getInstance()
            /*selectDate.apply {
                set(Calendar.YEAR,year)
                set(Calendar.MONTH,month)
                set(Calendar.DAY_OF_MONTH,dayOfMonth)
            }*/
            val date = formatDate.format(selectDate.time)
            binding.txtBirthday.setText(date)
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
    private fun setImeOptions(spinner: NumberPicker, spinnerIndex: Int) {
        val imeOptions: Int = if (spinnerIndex < SPINNER_COUNT - 1) {
            EditorInfo.IME_ACTION_NEXT
        } else {
            EditorInfo.IME_ACTION_DONE
        }
        val idPickerInput: Int = Resources.getSystem().getIdentifier("numberpicker_input", "id", "android")
        val input = spinner.findViewById<View>(idPickerInput) as TextView
        input.imeOptions = imeOptions
    }
    fun DatePicker.formatDate(dmyOrder : String){
        val spinnerDay =  findViewById<View>(Resources.getSystem().getIdentifier("day","id","android")) as NumberPicker
        val spinnerMonth =  findViewById<View>(Resources.getSystem().getIdentifier("month","id","android")) as NumberPicker
        val spinnerYear =  findViewById<View>(Resources.getSystem().getIdentifier("year","id","android")) as NumberPicker
        val layout =  findViewById<View>(Resources.getSystem().getIdentifier("pickers","id","android")) as LinearLayout
        layout.removeAllViews()

        for(i in 0 until SPINNER_COUNT){
            when(dmyOrder[i]){
                'd' -> {
                    layout.addView(spinnerDay)
                    setImeOptions(spinnerDay,i)
                }
                'm' -> {
                    layout.addView(spinnerMonth)
                    setImeOptions(spinnerMonth,i)
                }
                'y' -> {
                    layout.addView(spinnerYear)
                    setImeOptions(spinnerYear,i)
                }
                else -> throw IllegalArgumentException("Invalid char[] dmyOder")
            }
        }
    }
    fun dialogDatePicker(){
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_datepicker_spinner)

        val window: Window? = dialog.window
        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val windowAtrributes : WindowManager.LayoutParams = window!!.attributes
        windowAtrributes.gravity = Gravity.BOTTOM
        window.attributes = windowAtrributes
        //click ra bên ngoài để tắt dialog
        //false = no; true = yes
        dialog.setCancelable(false)
        dialog.show()
        //
        val apply = dialog.findViewById<TextView>(R.id.tvApply)
        val cancel = dialog.findViewById<TextView>(R.id.tvCancel)
        val datePicker = dialog.findViewById<DatePicker>(R.id.datePicker)
        apply.setOnClickListener {
            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1 //start return 0
            val year = datePicker.year
            binding.txtBirthday.setText("$day/$month/$year")
            dialog.dismiss()
        }
        cancel.setOnClickListener {
            dialog.dismiss()
        }
    }

}