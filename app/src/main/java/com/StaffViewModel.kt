package com

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.model.StaffModel
import com.test.repository.StaffRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StaffViewModel(
    private val staffRepository: StaffRepository
): ViewModel() {
    private val _staffs = MutableStateFlow(emptyList<StaffModel>())
    val staffs : StateFlow<List<StaffModel>> = _staffs
    fun fetchStaffList(){
        viewModelScope.launch {
            val staffList = staffRepository.getStaffList()
            _staffs.value = staffList
        }
    }
}