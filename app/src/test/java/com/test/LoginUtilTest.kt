package com.test

import com.test.model.LoginUtil
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test

class LoginUtilTest{
    val validLogin = LoginUtil("myUsername", "myPassword")
    val invalidLogin = LoginUtil("", "")

    //user and pass input not empty
    @Test
    fun `valid login returns true`() {
        assertTrue(validLogin.isValid())
    }
    //user and pass input empty
    @Test
    fun `invalid login returns false`() {
        assertFalse(invalidLogin.isValid())
    }
    @Test
    fun testLoginReturn() {
        val login = LoginUtil("username", "password")
        assertEquals("username", login.username)
        assertEquals("password", login.password)
    }
    //sử dụng mockK thực hiện tạo login giả dựa vào LoginUtil
    @Test
    fun testLoginWithMockK(){
        val username = "dotam"
        val password = "123"
        val mockLoginUtil = mockk<LoginUtil>()
        //return về user and pass giả
        every { mockLoginUtil.username } returns username
        every { mockLoginUtil.password } returns password
        assertEquals(username, mockLoginUtil.username)
        assertEquals(password, mockLoginUtil.password)
    }
}