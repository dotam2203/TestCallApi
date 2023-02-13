package com

import com.test.model.StaffModel
import com.test.repository.StaffRepositoryImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkClass
import org.junit.Assert.assertEquals
import org.junit.Test

class StaffViewModelTest {
    private val staffRepositoryImpl = mockk<StaffRepositoryImpl>()
    private lateinit var viewModel: StaffViewModel
    //khởi tạo ds staff mới để so sánh
    @Test
    fun testStaffViewModeWithMockK(){
        viewModel = mockkClass(StaffViewModel::class)
        val staffs = listOf(StaffModel(1, "dotam", 18), StaffModel(2, "ledo", 19), StaffModel(1, "lele", 20))
        every { viewModel.staffs.value }.returns(staffs)
        assertEquals(staffRepositoryImpl.getStaffList(), viewModel.staffs.value)
    }
}