package com.nilmani.jobworkmanagement.model.response

data class RespDeposit(
    val userId: Long = -1,
    val totalPieces: Long = -1,
    val deposit: Long = -1,
    val pending: Long = -1,
)
