package com.test.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.test.R
import com.test.adapter.DateViewPager
import com.test.databinding.CustomItemDatepickerBinding
import com.test.databinding.DialogDatepickerSpinnerBinding
import com.test.databinding.FragmentBirthdayBinding
import java.security.AccessController.getContext

class DatePickerCustomFragment: Fragment(){
    private lateinit var binding: CustomItemDatepickerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CustomItemDatepickerBinding.inflate(layoutInflater)

        return binding.root
    }
    fun getDate(){
        val dateViewPager = DateViewPager(requireContext())
        binding.calendarViewPager.adapter = dateViewPager
        //val dateAdapter = ArrayAdapter.createFromResource(requireContext(), ,R.layout.custom_item_datepicker)
        binding.dateSpinner.apply {
            //adapter = dateAdapter
            setSelection(0)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }
}