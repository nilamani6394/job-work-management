package com.nilmani.jobworkmanagement.model.response

data class RespAdmin(
    val name:String="",
    val email:String="",
    val password:String="",
    val phoneNumber:String="",
    val otp:Int=0
)
