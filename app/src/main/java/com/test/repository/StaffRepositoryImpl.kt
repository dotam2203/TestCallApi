package com.test.repository

import com.test.model.StaffModel

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  13/02/2023
 */
class StaffRepositoryImpl : StaffRepository{
    override fun getStaffList(): List<StaffModel> {
        return listOf(StaffModel(1, "dotam", 18), StaffModel(2, "ledo", 19), StaffModel(1, "lele", 20))
    }

}