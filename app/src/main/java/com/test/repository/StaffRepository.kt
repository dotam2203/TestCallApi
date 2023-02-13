package com.test.repository

import com.test.model.StaffModel

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  13/02/2023
 */
interface StaffRepository {
    fun getStaffList(): List<StaffModel>
}