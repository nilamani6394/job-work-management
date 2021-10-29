package com.nilmani.jobworkmanagement.model.request

data class ReqAdmin(
    val name:String="",
    val email:String="",
    val password:String="",
    val phoneNumber:String="",
    val otp:Int=0
)
