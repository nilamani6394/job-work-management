package com.nilmani.jobworkmanagement.model.response

import java.time.LocalDateTime

data class RespWithdrawMaterial(
    val userId:Long=-1,
    val materialType:String="",
    val quantity:Long=-1,
    val withdrawDate: LocalDateTime = LocalDateTime.now()
)
