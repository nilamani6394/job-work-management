package com.nilmani.jobworkmanagement.model.request

import java.time.LocalDateTime

data class ReqWithdrawMaterial(
    val userId:Long=-1,
    val materialType:String="",
    val quantity:Long=-1,
    val withdrawDate: LocalDateTime = LocalDateTime.now()
)
