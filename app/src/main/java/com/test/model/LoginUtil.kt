package com.test.model

data class LoginUtil(
    val username: String,
    val password: String
){
    fun isValid(): Boolean{
        return username.isNotEmpty() && password.isNotEmpty()
    }
}
